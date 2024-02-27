package peaksoft.repository;

import peaksoft.entity.Post;

import java.util.List;

public interface PostRepository {
    public Post savePost(Long userId, Post post);

    public void update(Long postId,Post newPost);

    public List<Post> getAllPosts();
    public List<Post> getUserPost(Long userId);
    public Post findPostById(Long postId);

//    public List<Post> getAllPostByUserId()

}
