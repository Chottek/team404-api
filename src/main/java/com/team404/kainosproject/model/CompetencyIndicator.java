package com.team404.kainosproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents an indicator of how a Kainos competency can be achieved.
 *
 * @author  team404
 */
@Entity
@Table(name = "competency_indicator")
public class CompetencyIndicator {

  @Id
  @Column(name = "competency_indicator_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "sub_competency_id", nullable = false)
  private SubCompetency subCompetency;

  @ManyToOne
  @JoinColumn(name = "band_id", nullable = false)
  private Band band;

  @Column(name = "description")
  private String description;

  public String getDescription() {
    return description;
  }

  // Don't Serialise Band Here ( as this is contained in Band )
  @JsonBackReference
  public Band getBand() {
    return band;
  }

  @JsonManagedReference
  public SubCompetency getSubCompetency() {
    return subCompetency;
  }
}
