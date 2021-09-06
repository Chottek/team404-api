package com.team404.kainosproject.controller;

import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.dto.BandJobFamiliesDto;
import com.team404.kainosproject.service.JobFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public Iterable<JobFamily> getAllJobFamilies() {
    return service.getAll();
  }

  /**
   * Gets a list of all Job Families for a particular capability
   * grouped by band.
   *
   * @return List of JobRole objects
   */
  @GetMapping("/job-matrix/{capability}")
  public Iterable<BandJobFamiliesDto> getJobMatrixByCapability(@PathVariable("capability") String capability){

    return service.getJobFamiliesForCapabilityByBand(capability);
  }


}
