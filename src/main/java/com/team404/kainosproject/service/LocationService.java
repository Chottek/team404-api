package com.team404.kainosproject.service;

import com.team404.kainosproject.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

  private final LocationRepository repository;

  @Autowired
  public LocationService(LocationRepository repository) {
    this.repository = repository;
  }

  public Iterable<String> getLocationNames(){
    return repository.getAllLocationNames();
  }


}
