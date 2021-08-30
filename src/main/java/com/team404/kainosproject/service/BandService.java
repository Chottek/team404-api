package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.repository.BandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandService {

    private static final Logger LOG = LoggerFactory.getLogger(BandService.class);

    private final BandRepository repository;

    @Autowired
    public BandService(BandRepository repository) {
        this.repository = repository;
    }

    /**
     * Gets a List of Band objects from database
     * @return Band objects list
     */
    public Iterable<Band> getAllCompetenciesByBand() {
        Iterable<Band> bands = repository.findAll();
        LOG.info("Got {} Band entries from database", bands.spliterator().estimateSize());
        return bands;
    }
}