package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.Location;

import java.util.List;

public class JobRoleDto {

  private Integer id;
  private String title;
  private String description;
  private String contractType;
  private List<Location> locations;
  private String capability;
  private String band;

  public JobRoleDto(Integer id, String title, String description, String contractType, List<Location> locations, String capability, String band) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.contractType = contractType;
    this.locations = locations;
    this.capability = capability;
    this.band = band;
  }

  public JobRoleDto(JobRole jr) {
    this.id = jr.getId();
    this.title = jr.getTitle();
    this.description = jr.getDescription();
    this.contractType = jr.getContractType();
    this.locations = jr.getLocations();
    this.capability = jr.getCapability();
    this.band = jr.getBandAsString();
  }

  public JobRoleDto() {
  }

  public Integer getId() {
    return id;
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
}