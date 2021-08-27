package com.team404.kainosproject.model;

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

    @OneToMany

    private List<SubCompetency> subCompetencies;

    public List<SubCompetency> getSubCompetencies() {
        return subCompetencies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
