package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Capability;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CapabilityRepository extends CrudRepository<Capability, Integer> {

  List<Capability> findByName(String name);

}
