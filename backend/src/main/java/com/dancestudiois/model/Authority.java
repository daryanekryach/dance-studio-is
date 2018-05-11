package com.dancestudiois.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
//@Entity
//@Table(name = "authority")
public class Authority {
    //@Id
    //@Column(name = "authority")
    private String authority;

/*    @ManyToOne
    @JoinColumn(name = "username")*/
    private User user;
}
