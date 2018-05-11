package com.dancestudiois.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
@Access(AccessType.PROPERTY)
public class User implements Serializable {

    private int id;

    @Column(name = "username")
    private String username;

    @Id
    @Column(name="id")
    public int getId(){
        return id;
    }


    private String password;
    @Column(name = "password_hash", nullable = false)
    public String getPassword() {
        return password;
    }

    @Column(name = "enabled", nullable = false)
    private boolean enabled;


    /*//@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @Transient
    private Set<Authority> authorities = new HashSet<>();*/
}
