package com.dancestudiois.service;

import com.dancestudiois.model.Post;

import java.util.List;

public interface TeamService {
    List<Post> getAllNews();
    Post getNewsById(String id);
    Post addNews(Post post);
    Post updateNews(Post post);
    void deleteNews(String id);
}
