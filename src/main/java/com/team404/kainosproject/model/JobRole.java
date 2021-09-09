package com.team404.kainosproject.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 * Job Role.
 *
 * @author team404
 */
@Entity
@Table(name = "job_role")
@SecondaryTable(name = "job_detail", pkJoinColumns = @PrimaryKeyJoinColumn(name = "job_id"))
public class JobRole {


  @ManyToMany
  @JoinTable(
      name = "job_location",
      joinColumns = @JoinColumn(name = "job_id"),
      inverseJoinColumns = @JoinColumn(name = "location_id")
  )
  List<Location> locations;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "job_id")
  private Integer id;
  @Column(name = "title")
  private String title;
  @Column(name = "description", table = "job_detail")
  private String description;
  @Column(name = "contractType")
  private String contractType;
  @Column(name = "posted")
  private String posted;

  @Column(name = "responsibilities")
  private String responsibilities;

  @ManyToOne
  @JoinColumn(name = "capability_id")
  private Capability capability;

  @ManyToOne
  @JoinColumn(name = "job_family_id")
  private JobFamily jobFamily;

  @ManyToOne
  @JoinColumn(name = "band_id", nullable = false)
  private Band band;

  @Column(name = "sharepoint_link")
  private String sharePointLink;

  public String getCapability() {
    return capability.getName();
  }

  public String getSharePointLink() {
    return sharePointLink;
  }

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

  public Band getBand() {
    return band;
  }

  public JobFamily getJobFamily() {
    return jobFamily;
  }

  public String getBandAsString() {
    return band.getName();
  }

  public String getPosted() {
    return posted;
  }

  public String getResponsibilities() {
    return responsibilities;
  }

  @Override
  public String toString() {
    return "JobRole{"
        + "id=" + id
        + ", title='" + title + '\''
        + ", description='" + description + '\''
        + ", contractType='" + contractType + '\''
        + '}';
  }
}
