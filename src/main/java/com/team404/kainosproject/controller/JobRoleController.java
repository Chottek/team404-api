package com.team404.kainosproject.controller;

import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.dto.JobRoleDto;
import com.team404.kainosproject.service.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public Iterable<JobRole> getAllJobRoles() {
    return service.getAll();
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
   * Adds a Job Role based on POST request Body
   *
   * @param jobRole DTO object containing Job Role data
   * @return ResponseEntity (200 OK) if created, (422 Unprocessable Entity) otherwise
   */
  @PostMapping("/job-roles/add")
  public ResponseEntity<?> addJobRole(@RequestBody JobRoleDto jobRole){
    if(service.addJobRole(jobRole)){
      return ResponseEntity.ok().build();
    }else {
      return ResponseEntity.unprocessableEntity().build();
    }
  }

}
