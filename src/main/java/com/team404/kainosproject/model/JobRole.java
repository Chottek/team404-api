package com.team404.kainosproject.model;

import javax.persistence.*;

@Entity
@Table(name="job_role")
@SecondaryTable(name="job_detail", pkJoinColumns = @PrimaryKeyJoinColumn(name="job_id"))
public class JobRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="job_id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="description", table = "job_detail")
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

    public String getContractType() {
        return contractType;
    }

    @Override
    public String toString() {
        return "JobRole{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", contractType='" + contractType + '\'' +
                '}';
    }
}
