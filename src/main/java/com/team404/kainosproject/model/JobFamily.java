package com.team404.kainosproject.model;

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

/**
 * Represents the job_family table.
 *
 * @author team 404
 */
@Entity
@Table(name = "job_family")
public class JobFamily {

  @Id
  @Column(name = "job_family_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "name")
  private String name;

  // TODO relationships with capability and job role

  @OneToMany(mappedBy = "jobFamily")
  private List<JobRole> jobRoles;

  @ManyToOne
  @JoinColumn(name = "capability_id")
  private Capability capability;

  public String getName() {
    return name;
  }

  public List<JobRole> getJobRoles() {
    return jobRoles;
  }

  public Integer getId() {
    return id;
  }

}
