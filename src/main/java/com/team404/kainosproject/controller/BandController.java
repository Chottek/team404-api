package com.team404.kainosproject.controller;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.dto.BandCompetenciesDto;
import com.team404.kainosproject.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controls requests relating to bands (management levels).
 *
 * @author team404
 */
@RestController
public class BandController {

  private final BandService service;

  @Autowired
  public BandController(BandService service) {
    this.service = service;
  }

  @GetMapping("/bandnames")
  public Iterable<String> getBandNames() {
    return service.getAllBandNames();
  }

  @GetMapping("/bands-competencies")
  public Iterable<BandCompetenciesDto> getBandDtos() {
    return service.getAllBandsDtos();
  }

}
