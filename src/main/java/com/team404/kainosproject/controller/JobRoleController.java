package com.team404.kainosproject.controller;

import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.service.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobRoleController {

  private final JobRoleService service;

  @Autowired
  public JobRoleController(JobRoleService service) {
    this.service = service;
  }

  /**
   * Gets a list of JobRole objects from JobRoleService.
   *
   * @return List of JobRole objects
   */
  @GetMapping("/job-roles") //produces = "application/json"
  public Iterable<JobRole> getAllJobRoles() {
    return service.getAll();
  }

}
