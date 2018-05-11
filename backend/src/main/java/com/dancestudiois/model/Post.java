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
@Table(name = "post")
@Access(AccessType.FIELD)
public class Post implements Serializable {
    @Id
    @Column(name="id")
    private int id;

    @Id
    @Column(name="id")
    public int getId(){
        return id;
    }

    @Column(name = "title")
    private String title;

    @Column(name = "post_text")
    private String text;

    @Temporal(TemporalType.DATE)
    @Column(name = "post_date")
    private Date date;
}
