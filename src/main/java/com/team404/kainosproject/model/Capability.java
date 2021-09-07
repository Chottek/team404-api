package com.team404.kainosproject.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Model Object representing the capability table.
 */
@Entity
@Table(name = "capability")
public class Capability {

  @Id
  @Column(name = "capability_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "capability")
  private List<JobRole> jobRoles;

  @OneToMany(mappedBy = "capability")
  private List<JobFamily> jobFamilies;

  public String getName() {
    return name;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public String toString() {
    return name;
  }
}
