package com.team404.kainosproject.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Location.
 *
 * @author team404
 */
@Entity
@Table(name = "location")
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "location_id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @ManyToMany(mappedBy = "locations")
  private List<JobRole> jobs;

  public String getName() {
    return name;
  }
}
