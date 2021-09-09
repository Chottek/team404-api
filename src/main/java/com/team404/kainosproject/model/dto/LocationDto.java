package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.Location;

/**
 * Data transfer object abstracting a {@link Location} model object.
 */
public class LocationDto {

  private final Integer id;
  private final String name;

  public LocationDto(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Create a new data transfer object from a model object.
   */
  public LocationDto(Location location) {

    id = location.getId();
    name = location.getName();
  }

  public String getName() {
    return name;
  }
}
