package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Band;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends CrudRepository<Band, Integer> {
}
