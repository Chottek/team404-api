package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.Location;

import java.util.List;

public class JobRoleDto {

  //TODO: Nothing in common with US005

  private String title;
  private String description;
  private String contractType;
  private List<Location> locations;
  private String capability;
  private String band;
  private String sharePointLink;
  private String jobFamilyName;


  public JobRoleDto(String title, String description, String contractType, List<Location> locations, String capability, String band, String sharePointLink, String jobFamilyName) {
    this.title = title;
    this.description = description;
    this.contractType = contractType;
    this.locations = locations;
    this.capability = capability;
    this.band = band;
    this.jobFamilyName = jobFamilyName;
    this.sharePointLink = sharePointLink;
  }

  public JobRoleDto(JobRole jr) {
    this.title = jr.getTitle();
    this.description = jr.getDescription();
    this.contractType = jr.getContractType();
    this.locations = jr.getLocations();
    this.capability = jr.getCapability().toString();
    this.band = jr.getBandAsString();
    this.sharePointLink = jr.getSharePointLink();

    if(jr.getJobFamily() != null){
      this.jobFamilyName = jr.getJobFamily().getName();
    }
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

  public List<Location> getLocations() {
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