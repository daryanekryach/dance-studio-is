package com.dancestudiois.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "team")
@Access(AccessType.PROPERTY)
public class Team extends DanceClass {

        @Column(name = "title")
        private String title;

}
