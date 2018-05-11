package com.dancestudiois.dao;

import com.dancestudiois.model.DanceClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanceClassRepository extends JpaRepository<DanceClass, Integer> {
}
