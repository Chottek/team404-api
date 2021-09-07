package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

  String FIND_NAMES = "SELECT DISTINCT name FROM location";

  @Query(value = FIND_NAMES, nativeQuery = true)
  Iterable<String> getAllLocationNames();

}
