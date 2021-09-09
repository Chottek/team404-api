package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.Location;
import java.util.List;

public class LocationDto {

  private final Integer id;
  private final String name;

  public LocationDto(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public LocationDto(Location location) {

    id = location.getId();
    name = location.getName();
  }

  public String getName() {
    return name;
  }
}
