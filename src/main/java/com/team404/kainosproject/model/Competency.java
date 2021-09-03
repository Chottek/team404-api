package com.team404.kainosproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.servlet.annotation.HttpConstraint;
import java.util.List;

@Entity
@Table(name = "competency")
public class Competency {

    @Id
    @Column(name = "competency_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    // Note that the mappedBy property is the property in the many class to map too
    @OneToMany(mappedBy = "competency")
    private List<SubCompetency> subCompetencies;

    @JsonBackReference
    public List<SubCompetency> getSubCompetencies() {
        return subCompetencies;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}