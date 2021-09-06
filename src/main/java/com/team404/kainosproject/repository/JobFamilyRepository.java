package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.JobFamily;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * abstraction for accessing the job family table.
 *
 * @author team404
 */
public interface JobFamilyRepository extends CrudRepository<JobFamily, Integer> {

  List<JobFamily> findByCapability(int capabilityID);

}
