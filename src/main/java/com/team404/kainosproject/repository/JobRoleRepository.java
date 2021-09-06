package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.Capability;
import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.JobRole;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Job Role Repository.
 *
 * @author team404
 */
@Repository
public interface JobRoleRepository extends CrudRepository<JobRole, Integer> {

  List<JobRole> findByCapability(int capabilityId);

  List<JobRole> findByCapabilityAndBandAndJobFamily(Capability capability, Band band, JobFamily jobFamily);
}
