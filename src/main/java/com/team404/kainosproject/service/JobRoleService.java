package com.team404.kainosproject.service;

import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.repository.JobRoleRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Job Role Service.
 *
 * @author team404
 */
@Service
public class JobRoleService {

  private static final Logger LOG = LoggerFactory.getLogger(JobRoleService.class);

  private final JobRoleRepository repository;

  @Autowired
  public JobRoleService(JobRoleRepository repository) {
    this.repository = repository;
  }

  /**
   * Gets a List of JobRole objects from database.
   *
   * @return JobRole objects list
   */
  public Iterable<JobRole> getAll() {
    Iterable<JobRole> jobRoles = repository.findAll();
    LOG.info("Got {} JobRole entries from database", jobRoles.spliterator().estimateSize());
    return jobRoles;
  }

  /**
   * Gets an Optional of JobRole from database, based on ID.
   *
   * @param id Numeric id of Job Role in database
   * @return Optional of JobRole in database
   */
  public Optional<JobRole> getById(int id) {
    Optional<JobRole> jobRole = repository.findById(id);
    if (jobRole.isPresent()) {
      LOG.info("Got JobRole with id [{}]", id);
    } else {
      LOG.error("No JobRole with id [{}] found!", id);
    }
    return jobRole;
  }

}
