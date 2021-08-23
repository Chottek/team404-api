package com.team404.kainosproject.model;

import javax.persistence.*;

@Entity
@Table(name="job_role")
public class JobRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="job_id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="contractType")
    private String contractType;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
