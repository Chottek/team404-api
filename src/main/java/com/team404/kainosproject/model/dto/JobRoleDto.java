package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.Location;
import java.util.List;
import java.util.stream.Collectors;

public class JobRoleDto {

  private int id;
  private final String title;
  private String description;
  private final String contractType;
  private final List<LocationDto> locations;
  private final String capability;
  private String band;
  private final String sharePointLink;
  private String jobFamilyName;

  private String responsibilities;

  /**
   * Create a new Data Transfer Object to contain the below information.
   *
   * @param title        job title
   * @param description  job description
   * @param contractType type of contract (part_time, full_time, consultant)
   * @param locations    office locations job is available for
   * @param capability   Kainos capability that the job belongs to
   * @param band         management level of the job
   */
  public JobRoleDto(String title, String description, String contractType, List<LocationDto> locations,
      String capability, String band,
      String sharePointLink, String jobFamilyName, String responsibilities) {
    this.title = title;
    this.description = description;
    this.contractType = contractType;
    this.locations = locations;
    this.capability = capability;
    this.band = band;
    this.jobFamilyName = jobFamilyName;
    this.sharePointLink = sharePointLink;
    this.responsibilities = responsibilities;
  }

  public JobRoleDto(JobRole jobRole) {
    this.id = jobRole.getId();
    this.title = jobRole.getTitle();
    this.description = jobRole.getDescription();
    this.contractType = jobRole.getContractType();
    this.capability = jobRole.getCapability();
    this.band = jobRole.getBandAsString();
    this.sharePointLink = jobRole.getSharePointLink();
    //this.responsibilities = jr.getResponsibilities();

    this.locations = jobRole.getLocations()
                        .stream()
                        .map(LocationDto::new)
                        .collect(Collectors.toList());

    if (jobRole.getJobFamily() != null) {
      this.jobFamilyName = jobRole.getJobFamily().getName();
    }
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getContractType() {
    return contractType;
  }

  public List<LocationDto> getLocations() {
    return locations;
  }

  public String getCapability() {
    return capability;
  }

  public String getBand() {
    return band;
  }

  public void setBand(String band) {
    this.band = band;
  }

  public String getSharePointLink() {
    return sharePointLink;
  }

  public String getJobFamilyName() {
    return jobFamilyName;
  }
}
