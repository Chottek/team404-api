package com.team404.kainosproject.model;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "job_location",
            joinColumns = @JoinColumn(name="job_id"),
            inverseJoinColumns = @JoinColumn(name="location_id")
    )
    List<Location> locations;

    @Column(name = "responsibilities")
    private String responsibilities;

    @Column(name="capability")
    private String capability;

    @Column(name="band")
    private String band;

    public String getCapability() { return capability; }

    public List<Location> getLocations() {
        return locations;
    }

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

    public String getBand() {
        return band;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    @Override
    public String toString() {
        return "JobRole{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", contractType='" + contractType + '\'' +
                ", locations=" + locations +
                ", responsibilities='" + responsibilities + '\'' +
                ", capability='" + capability + '\'' +
                ", band='" + band + '\'' +
                '}';
    }
}
