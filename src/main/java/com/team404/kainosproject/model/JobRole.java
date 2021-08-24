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

    @Column(name="contractType")
    private String contractType;

    @Column(name="posted")
    private String posted;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContractType() {
        return contractType;
    }

    @Override
    public String toString() {
        return "JobRole{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contractType='" + contractType + '\'' +
                ", posted='" + posted + '\'' +
                '}';
    }
}
