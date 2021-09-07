package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Capability;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Abstraction for the storage of Capability Objects.
 */
public interface CapabilityRepository extends CrudRepository<Capability, Integer> {

  List<Capability> findByName(String name);

}
