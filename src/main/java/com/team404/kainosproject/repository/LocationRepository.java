package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Location;
import org.springframework.data.repository.CrudRepository;

/**
 * Provides an abstraction for accessing the location table.
 */
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
