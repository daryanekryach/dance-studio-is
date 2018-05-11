package com.dancestudiois.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "schedule")
@Access(AccessType.PROPERTY)
public class Schedule implements Serializable {

    private int id;

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    public int getId() {
        return id;
    }


    private DanceClass danceClass;

    //@Column(name = "danceClass")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dance_class", referencedColumnName = "id")
    public DanceClass getDanceClass() {
        return danceClass;
    }

    @Column(name = "weekday")
    private String weekday;


    private Date startTime;


    private Date endTime;

    @Temporal(TemporalType.TIME)
    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    @Temporal(TemporalType.TIME)
    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }


    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room", referencedColumnName = "id")
    public Room getRoom() {
        return room;
    }
}
