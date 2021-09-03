package com.team404.kainosproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
