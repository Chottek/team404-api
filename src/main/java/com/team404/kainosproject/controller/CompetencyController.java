package com.team404.kainosproject.controller;

import com.team404.kainosproject.model.Competency;
import com.team404.kainosproject.service.CompetencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controls requests relating to Kainos competencies.
 *
 * @author team404
 */
@RestController
public class CompetencyController {

  private final CompetencyService service;

  @Autowired
  public CompetencyController(CompetencyService service) {
    this.service = service;
  }

  @GetMapping("/competencies")
  public Iterable<Competency> getAllCompetencies() {
    return service.getAllCompetencies();
  }

}
