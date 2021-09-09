package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Capability;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Provides an abstraction for accessing the capability table.
 */
public interface CapabilityRepository extends CrudRepository<Capability, Integer> {

  List<Capability> findByName(String name);

}
