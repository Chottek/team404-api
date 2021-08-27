package com.team404.kainosproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sub_competency")
public class SubCompetency {

    @Id
    @Column(name = "sub_competency_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="competency_id", nullable = false)
    private Competency competency;

    @Column
    private String name;

    // Note that the mappedBy property is the property in the many class to map too
    @OneToMany(mappedBy = "subCompetency")
    private List<CompetencyIndicator> competencyIndicators;

    public String getName() {
        return name;
    }

    @JsonBackReference
    public List<CompetencyIndicator> getCompetencyIndicators() {
        return competencyIndicators;
    }

    @JsonManagedReference
    public Competency getCompetency() {
        return competency;
    }
}
