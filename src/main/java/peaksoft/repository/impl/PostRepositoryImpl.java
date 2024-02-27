package peaksoft.repository.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.repository.PostRepository;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class PostRepositoryImpl  implements PostRepository {

    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public Post savePost(Long userId, Post post) {
        User user = entityManager.find(User.class, userId);
        post.setUser(user);
        post.setCratedAt(LocalDate.now());
        entityManager.persist(post);

        return post;
    }

    @Override
    public void update(Long postId, Post newPost) {
//        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, postId);
        post.setDescription(newPost.getDescription());
        post.setTittle(newPost.getTittle());
//        entityManager.getTransaction().commit();

    }


    @Override
    public List<Post> getAllPosts() {

       return entityManager.createQuery("select p from Post p", Post.class)
                .getResultList();

    }

    @Override
    public List<Post> getUserPost(Long userId) {
        User user = entityManager.find(User.class, userId);
       return user.getPosts();
//        List<Post> posts = new ArrayList<>();
//        entityManager.createQuery("select u from User u where u.id =:add",User.class)
//                 .setParameter("add",userId)
//                 .getResultList();
//       return posts;
    }

    @Override
    public Post findPostById(Long postId){
        Post post = entityManager.find(Post.class,postId);
        return post;
    }
}
