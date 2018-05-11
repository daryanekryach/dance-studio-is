package com.dancestudiois.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Data
@Entity
@Table(name = "dance_class")
@Access(AccessType.PROPERTY)
public class DanceClass implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }


    private Choreographer choreographer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "choreographer", referencedColumnName = "id")
    public Choreographer getChoreographer() {
        return choreographer;
    }

    @Column(name = "style")
    private String style;

    @Column(name = "level")
    private String level;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "danceClass")
    private Set<Schedule> schedule;

    @OneToMany(mappedBy = "danceClass")
    public Set<Schedule> getSchedule() {
        return schedule;
    }

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @ManyToMany(mappedBy = "danceClasses")
    private Set<Student> dancers;

    @ManyToMany(mappedBy = "danceClasses")
    public Set<Student> getDancers() {
        return dancers;
    }
}
