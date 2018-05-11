package com.dancestudiois.dao;

import com.dancestudiois.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<Post, Integer> {
}
