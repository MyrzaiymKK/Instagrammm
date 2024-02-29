package peaksoft.service.impl;

import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.contoller.UserController;
import peaksoft.entity.Image;
import peaksoft.entity.Like;
import peaksoft.entity.Post;
import peaksoft.repository.PostRepository;
import peaksoft.service.PostService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;


    @Override
    public void savePost(Long userId, Post post) {

        Like like = new Like();
        like.setPost(post);
        post.setLike(like);

        String imageUrl = post.getImageUrl();
        Image image = new Image();
        image.setPost(post);
        image.setImageUrl(imageUrl);
        post.addImage(image);
        UserController.currentUser.getPosts().add(post);
        postRepository.savePost(userId,post);
    }

    @Override
    public List<Post> getAllPosts() {
       return postRepository.getAllPosts();
    }

    @Override
    public List<Post> getUserPost(Long userId) {

        return  postRepository.getUserPost(userId);

    }

    @Override
    public void update(Long postId, Post newPost) {
        postRepository.update(postId,newPost);
    }

    @Override
    public Post findPostById(Long postId) {
        return postRepository.findPostById(postId);
    }
}
