package com.team404.kainosproject.controller;

import com.team404.kainosproject.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

  private final LocationService service;

  @Autowired
  public LocationController(LocationService service) {
    this.service = service;
  }

  @GetMapping
  public Iterable<String> locationNames(){
    return service.getLocationNames();
  }
}
