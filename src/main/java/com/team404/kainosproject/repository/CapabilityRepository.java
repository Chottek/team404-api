package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Capability;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapabilityRepository extends CrudRepository<Capability, Integer> {

  @Query(value = "SELECT c FROM Capability c WHERE name=?1")
  Optional<Capability> getByName(String name);

}
