package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.dto.BandDto;
import com.team404.kainosproject.model.dto.CompetencyDto;
import com.team404.kainosproject.model.dto.IndicatorDto;
import com.team404.kainosproject.repository.BandRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Used to access stored information about kainos bands (management levels).
 *
 * @author team404
 */
@Service
public class BandService {

  private static final Logger LOG = LoggerFactory.getLogger(BandService.class);

  private final BandRepository repository;

  @Autowired
  public BandService(BandRepository repository) {
    this.repository = repository;
  }

  /**
   * Gets a List of Band objects from database.
   *
   * @return Band objects list
   */
  public Iterable<Band> getAllBands() {
    Iterable<Band> bands = repository.findAll();
    LOG.info("Got {} Band entries from database", bands.spliterator().estimateSize());
    return bands;
  }

  /**
   * Gets a List of Band objects from database and maps it to the BandDTO
   * of form that can be easily parsed.
   *
   * @return Iterable of BandDTO objects
   */
  public Iterable<BandDto> getAllBandsDtos() {
    Iterable<Band> bands = repository.findAll();
    List<String> competencies = new ArrayList<>();
    List<String> bandNames = new ArrayList<>();

    bands.forEach(e -> {
      e.getCompetencyIndicators()
          .stream()
          .filter(ind -> !competencies.contains(ind.getSubCompetency().getCompetency().getName()))
          .forEach(ind -> competencies.add(ind.getSubCompetency().getCompetency().getName()));

      e.getCompetencyIndicators()
          .stream()
          .map(ce -> ce.getBand().getName())
          .distinct()
          .forEach(bandNames::add);
    });

    List<BandDto> bandDtosList = new ArrayList<>();

    for (String bandName : bandNames) {
      BandDto bandDto = new BandDto();
      bandDto.setBand(bandName);
      final List<CompetencyDto> competencyDtos = new ArrayList<>();
      for (String competency : competencies) {
        final List<IndicatorDto> indicators = new ArrayList<>();
        bands.forEach(e ->
            e.getCompetencyIndicators()
                .stream()
                .filter(s -> s.getSubCompetency().getCompetency().getName().equals(competency))
                .filter(s -> s.getBand().getName().equals(bandName))
                .map(cp -> new IndicatorDto(cp.getSubCompetency().getName(), cp.getDescription()))
                .forEach(indicators::add));
        if (!indicators.isEmpty()) {
          competencyDtos.add(new CompetencyDto(competency, indicators));
          LOG.info("[{}] BandDTO indicators list contains [{}] entries for competency [{}]",
              bandName, indicators.size(), competency);
        } else {
          LOG.error("[{}] BandDTO -> NO ENTRIES FROM competency [{}]", bandName, competency);
        }
      }
      LOG.info("[{}] BandDTO contains [{}] competencies", bandName, competencyDtos.size());
      bandDto.setCompetencies(competencyDtos);
      bandDtosList.add(bandDto);
    }
    LOG.info("Created [{}] Band Data Transfer Objects from Band model", bandDtosList.size());
    return bandDtosList;
  }


  /**
   * Gets a list of Band names as String distinctly
   * from database, in order of priority
   *
   * @return Iterable of Band name Strings
   */
  public Iterable<String> getAllBandNames(){
    return repository.getAllBandNames();
  }


}