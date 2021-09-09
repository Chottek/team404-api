package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.Location;
import java.util.List;

public class LocationDto {

  private final Integer id;
  private final String name;
  private final List<JobRole> jobs;

  public LocationDto(Integer id, String name,
      List<JobRole> jobs) {
    this.id = id;
    this.name = name;
    this.jobs = jobs;
  }

  public LocationDto(Location location) {

    id = location.getId();
    name = location.getName();
    jobs = location.getJobs();
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
