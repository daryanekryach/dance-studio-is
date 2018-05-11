package com.dancestudiois.service;


import com.dancestudiois.model.DanceClass;

import java.util.List;

public interface DanceClassService {
    List<DanceClass> getAllDanceClass();
    DanceClass getDanceClassById(String id);
    DanceClass addDanceClass(DanceClass danceClass);
    DanceClass updateDanceClass(DanceClass danceClass);
    void deleteDanceClass(String id);
}
