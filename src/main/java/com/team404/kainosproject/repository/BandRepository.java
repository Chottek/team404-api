package com.team404.kainosproject.repository;

import com.team404.kainosproject.model.Band;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository is an abstraction for storing the Band (management levels) object.
 *
 * @author team404
 */
@Repository
public interface BandRepository extends CrudRepository<Band, Integer> {

    /*@Query("SELECT b FROM Band b " +
            "JOIN CompetencyIndicator USING (band_id) " +
            "JOIN SubCompetency USING (sub_competency_id) " +
            "JOIN Competency USING (competency_id)")
    Iterable<Band> getBandsList();*/


}
