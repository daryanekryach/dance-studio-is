package com.dancestudiois.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "room")
@Access(AccessType.PROPERTY)
public class Room {
    @Id
    @Column(name="id")
    private int id;

    @Id
    @Column(name="id")
    public int getId(){
        return id;
    }

    @Column(name="title")
    private String title;

    @Column(name="size")
    private int size;

    @Column(name="price")
    private int price;


    private Set<Schedule> schedule;

    @OneToMany(mappedBy="room")
    public Set<Schedule> getSchedule() {
        return schedule;
    }
}
