package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.Competency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetencyRepository extends CrudRepository<Competency, Integer> {
}
