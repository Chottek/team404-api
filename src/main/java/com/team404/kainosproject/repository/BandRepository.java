package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Band;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository is an abstraction for storing the Band (management levels) object.
 *
 * @author team404
 */
@Repository
public interface BandRepository extends CrudRepository<Band, Integer> {

  List<Band> findAll(Sort sort);
}