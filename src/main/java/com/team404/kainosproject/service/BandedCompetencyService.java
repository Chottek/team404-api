package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.repository.BandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandedCompetencyService {

    private static final Logger LOG = LoggerFactory.getLogger(CompetencyService.class);

    private final BandRepository repository;

    @Autowired
    public BandedCompetencyService(BandRepository repository) {
        this.repository = repository;
    }

    /**
     * Gets a List of Competency objects from database
     *
     * @return Competency objects list
     */
    public Iterable<Band> getAllCompetenciesByBand() {
        Iterable<Band> competencies = repository.findAll();
        LOG.info("Got {} Competency entries from database", competencies.spliterator().estimateSize());
        return competencies;
    }
}