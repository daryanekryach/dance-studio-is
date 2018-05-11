package com.dancestudiois.service;

import com.dancestudiois.model.Choreographer;

import java.util.List;

public interface ChoreographerService {
    List<Choreographer> getAllChoreographers();
    Choreographer getChoreographerById(String id);
    Choreographer addChoreographer(Choreographer movie);
    Choreographer updateChoreographer(Choreographer movie);
    void deleteChoreographer(String id);
}
