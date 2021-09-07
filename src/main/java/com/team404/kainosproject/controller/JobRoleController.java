package com.team404.kainosproject.controller;

import com.team404.kainosproject.model.dto.BandJobFamiliesDto;
import com.team404.kainosproject.model.dto.JobRoleDto;
import com.team404.kainosproject.service.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Job Role Controller.
 *
 * @author team404
 */
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
  public Iterable<JobRoleDto> getAllJobRoles() {
    return service.getAllDto();  // fixme this needs to be a DTO
  }

  /**
   * Gets Job Role object based on ID.
   *
   * @param id Numeric id of Job Role in database
   * @return ResponseEntity containing an object if it exists,
   *         else ResponseEntity with 404 Not Found Status
   */
  @GetMapping("/job-roles/{id}")
  public ResponseEntity<JobRoleDto> getById(@PathVariable("id") int id) {
    return service.getById(id).map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  /**
   * Gets a list of all Job Families for a particular capability
   * grouped by band.
   *
   * @return List of JobRole objects
   */
  @GetMapping("/job-matrix/{capability}")
  public Iterable<BandJobFamiliesDto> getJobMatrixByCapability(@PathVariable("capability") String capability){

    return service.getJobBandFamilyMatrixByCapability(capability);
  }
}
