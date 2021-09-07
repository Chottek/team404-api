package com.team404.kainosproject.controller;

import com.team404.kainosproject.model.dto.JobFamilyDto;
import com.team404.kainosproject.service.JobFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controls requests involving job families.
 *
 * @author team404
 */
@RestController
public class JobFamilyController {

  private final JobFamilyService service;

  @Autowired
  public JobFamilyController(JobFamilyService service) {
    this.service = service;
  }

  /**
   * Gets a list of all Job Families.
   *
   * @return List of JobRole objects
   */
  @GetMapping("/job-family") //produces = "application/json"
  public Iterable<JobFamilyDto> getAllJobFamilies() {
    return service.getAllAsDto();
  }
}
