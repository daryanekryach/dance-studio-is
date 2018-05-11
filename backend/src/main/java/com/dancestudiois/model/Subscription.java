package com.dancestudiois.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "subscription")
@Access(AccessType.PROPERTY)
public class Subscription implements Serializable {

    private int id;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private int price;


    private int classesAmount;

    @Column(name = "classes_amount")
    public int getClassesAmount() {
        return classesAmount;
    }

    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student", referencedColumnName = "id")
    public Student getStudent() {
        return student;

    }
}
