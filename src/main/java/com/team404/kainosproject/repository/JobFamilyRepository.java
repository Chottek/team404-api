package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.JobFamily;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobFamilyRepository extends CrudRepository<JobFamily, Integer> {

  @Query("SELECT j FROM JobFamily j WHERE name=?1")
  Optional<JobFamily> getByName(String name);

}
