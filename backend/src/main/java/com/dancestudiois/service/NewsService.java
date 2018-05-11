package com.dancestudiois.service;

import com.dancestudiois.model.Post;

import java.util.List;

public interface NewsService {
    List<Post> getAllPosts();
    Post getPostById(String id);
    Post addPost(Post post);
    Post updatePost(Post post);
    void deletePost(String id);
}
