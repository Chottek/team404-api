package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.dto.BandDTO;
import com.team404.kainosproject.model.dto.CompetencyIndicatorDTO;
import com.team404.kainosproject.repository.BandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Iterable<Band> getAllBands() {
        Iterable<Band> bands = repository.findAll();
        LOG.info("Got {} Band entries from database", bands.spliterator().estimateSize());
        return bands;
    }

    /**
     * Gets a List of Band objects from database and
     * maps it to the BandDTO of form that can be easily parsed
     * @return Iterable of BandDTO objects
     */
    public Iterable<BandDTO> getAllBandsDTOs(){
        Iterable<Band> bands = repository.findAll();
        List<BandDTO> bandDTOS = new ArrayList<>();
        bands.forEach(e -> {
            List<CompetencyIndicatorDTO> ciDTOS = e.getCompetencyIndicators().stream()
                    .map(ce -> new CompetencyIndicatorDTO(
                            ce.getSubCompetency().getCompetency().getName(),
                            ce.getDescription(),
                            ce.getSubCompetency().getName())).collect(Collectors.toList());
            bandDTOS.add(new BandDTO(e.getName(), ciDTOS));
        });
        LOG.info("Created [{}] Band Data Transfer Objects from Band model", bandDTOS.size());
        return bandDTOS;
    }

}