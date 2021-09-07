package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Band;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository is an abstraction for storing the Band (management levels) object.
 *
 * @author team404
 */
@Repository
public interface BandRepository extends CrudRepository<Band, Integer> {

  @Query("SELECT b FROM Band b WHERE name=?1")
  Optional<Band> getByName(String name);

}
