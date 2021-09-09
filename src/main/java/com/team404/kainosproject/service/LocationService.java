package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Location;
import com.team404.kainosproject.model.dto.LocationDto;
import com.team404.kainosproject.repository.LocationRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Used to retrieve information about kainos office locations.
 */
@Service
public class LocationService {

  private final LocationRepository repository;

  @Autowired
  public LocationService(LocationRepository repository) {
    this.repository = repository;
  }

  /**
   * Get a list of locations as data transfer objects.
   */
  public Iterable<LocationDto> getAllDtos() {

    return ((List<Location>) repository.findAll())
        .stream()
        .map(LocationDto::new)
        .collect(Collectors.toList());
  }
}
