package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.Location;

import java.util.List;

public class JobRoleDto {

  //TODO: Nothing in common with US005

  private String title;
  private String description;
  private String contractType;
  private List<String> locations;
  private String capability;
  private String responsibilities;
  private String band;
  private String jobFamily;
  private String sharepointLink;


  public JobRoleDto(String title, String description, String contractType,
      List<String> locations, String capability, String band, String sharepointLink, String jobFamily, String responsibilities) {
    this.title = title;
    this.description = description;
    this.contractType = contractType;
    this.locations = locations;
    this.capability = capability;
    this.band = band;
    this.sharepointLink = sharepointLink;
    this.jobFamily = jobFamily;
    this.responsibilities = responsibilities;
  }

  public JobRoleDto(JobRole jr) {
    this.title = jr.getTitle();
    this.description = jr.getDescription();
    this.contractType = jr.getContractType();

    jr.getLocations().forEach(location -> this.locations.add(location.getName()));

    this.capability = jr.getCapability();
    this.band = jr.getBandAsString();
    this.sharepointLink = jr.getSharePointLink();
    this.jobFamily = jr.getJobFamily().getName();
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

  public List<String> getLocations() {
    return locations;
  }

  public void setLocations(List<String> locations) {
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

  public String getSharepointLink() {
    return sharepointLink;
  }

  public void setSharepointLink(String sharepointLink) {
    this.sharepointLink = sharepointLink;
  }

  public String getJobFamily() {
    return jobFamily;
  }

  public void setJobFamily(String jobFamily) {
    this.jobFamily = jobFamily;
  }

  public String getResponsibilities() {
    return responsibilities;
  }

  public void setResponsibilities(String responsibilities) {
    this.responsibilities = responsibilities;
  }

  @Override
  public String toString() {
    return "JobRoleDto{" +
        "title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", contractType='" + contractType + '\'' +
        ", locations=" + locations +
        ", capability='" + capability + '\'' +
        ", band='" + band + '\'' +
        ", jobFamily='" + jobFamily + '\'' +
        ", sharepointLink='" + sharepointLink + '\'' +
        ", responsibilities='" + responsibilities + '\'' +
        '}';
  }
}