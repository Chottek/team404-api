package com.team404.kainosproject.model;

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
    @JoinColumn(name = "competency_id", nullable = false)
    private Competency competency;

    @OneToMany
    @JoinColumn(name = "competency_indicator_id", nullable = false)
    private List<CompetencyIndicator> competencyIndicators;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Competency getCompetency() {
        return competency;
    }

    public void setCompetency(Competency competency) {
        this.competency = competency;
    }

    public List<CompetencyIndicator> getCompetencyIndicators() {
        return competencyIndicators;
    }

    public void setCompetencyIndicators(List<CompetencyIndicator> competencyIndicators) {
        this.competencyIndicators = competencyIndicators;
    }
}
