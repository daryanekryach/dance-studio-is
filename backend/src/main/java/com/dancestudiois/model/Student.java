package com.dancestudiois.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Id;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "student")
@Access(AccessType.PROPERTY)
public class Student implements Serializable {
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


    private Date joinDate;


    private Date birthDate;

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


    @Column(name = "rating")
    private int rating;

    @OneToMany(mappedBy = "student")
    private Set<Subscription> subscriptions;

    @OneToMany(mappedBy = "student")
    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    //@OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    private Set<DanceClass> danceClasses;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_class",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_id")}
    )
    public Set<DanceClass> getDanceClasses() {
        return danceClasses;
    }
}
