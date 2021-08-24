package com.team404.kainosproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="location_id")
    private Integer id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "locations")
    private List<JobRole> jobs;

    public String getName() {
        return name;
    }
}
