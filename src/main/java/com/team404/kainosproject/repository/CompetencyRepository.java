package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Competency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Abstraction for storing information about Kainos Competencies.
 *
 * @author team404
 */
@Repository
public interface CompetencyRepository extends CrudRepository<Competency, Integer> {

}
