package com.dancestudiois.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "choreographer")
@Access(AccessType.PROPERTY)
public class Choreographer implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Temporal(TemporalType.DATE)
    @Column(name = "join_date")
    public Date getJoinDate() {
        return joinDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }


    private Date joinDate;

    private Date birthDate;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "choreographer")

    private Set<DanceClass> danceClasses;

    @OneToMany(mappedBy = "choreographer")
    public Set<DanceClass> getDanceClasses() {
        return danceClasses;
    }

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "choreographer")

    private Set<Team> teams;

    @OneToMany(mappedBy = "choreographer")
    public Set<Team> getTeams() {
        return teams;
    }
}
