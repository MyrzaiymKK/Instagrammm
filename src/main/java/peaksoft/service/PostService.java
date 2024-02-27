package peaksoft.service;

import peaksoft.entity.Post;

import java.util.List;

public interface PostService {
    public void savePost(Long userId, Post post);
    public List<Post> getAllPosts();
    public List<Post> getUserPost(Long userId);
    public void update(Long postId,Post newPost);
    public Post findPostById(Long postId);
}
