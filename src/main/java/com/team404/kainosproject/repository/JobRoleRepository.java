package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.JobRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Job Role Repository.
 *
 * @author team404
 */
@Repository
public interface JobRoleRepository extends CrudRepository<JobRole, Integer> {

}
