package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.JobRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRoleRepository extends CrudRepository<JobRole, Integer> {

}
