package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.Location;
import java.util.List;

/**
 * A Data Transfer Object abstracting a job role.
 *
 * @author team404
 */
public class JobRoleDto {

  //TODO: Nothing in common with US005

  private String title;
  private String description;
  private String contractType;
  private List<Location> locations;
  private String capability;
  private String band;
  private String responsibilities;
  private String sharepoint;

  /**
   * Create a new Data Transfer Object to contain the below information.
   *
   * @param title job title
   * @param description job description
   * @param contractType type of contract (part_time, full_time, consultant)
   * @param locations office locations job is available for
   * @param capability Kainos capability that the job belongs to
   * @param band management level of the job
   */
  public JobRoleDto(String title, String description, String contractType, List<Location> locations,
      String capability, String band, String responsibilities) {
    this.title = title;
    this.description = description;
    this.contractType = contractType;
    this.locations = locations;
    this.capability = capability;
    this.band = band;
    this.responsibilities = responsibilities;
  }

  /**
   * Initialise a data transfer object from a JobRole model.
   *
   * @param jr a job role model object
   */
  public JobRoleDto(JobRole jr) {
    this.title = jr.getTitle();
    this.description = jr.getDescription();
    this.contractType = jr.getContractType();
    this.locations = jr.getLocations();
    this.capability = jr.getCapability();
    this.band = jr.getBandAsString();
    this.responsibilities = jr.getResponsibilities();
    this.sharepoint = jr.getSharePointLink();
  }

  public JobRoleDto() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  public void setContractType(String contractType) {
    this.contractType = contractType;
  }

  public List<Location> getLocations() {
    return locations;
  }

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }

  public String getCapability() {
    return capability;
  }

  public void setCapability(String capability) {
    this.capability = capability;
  }

  public String getBand() {
    return band;
  }

  public void setBand(String band) {
    this.band = band;
  }

  public String getResponsibilities() {
    return responsibilities;
  }

  public String getSharepoint() {
    return sharepoint;
  }
}
