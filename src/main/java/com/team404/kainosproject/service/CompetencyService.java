package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Competency;
import com.team404.kainosproject.repository.CompetencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetencyService {

  private static final Logger LOG = LoggerFactory.getLogger(CompetencyService.class);

  private final CompetencyRepository repository;

  @Autowired
  public CompetencyService(CompetencyRepository repository) {
    this.repository = repository;
  }

  /**
   * Gets a List of Competency objects from database
   *
   * @return Competency objects list
   */
  public Iterable<Competency> getAllCompetencies() {
    Iterable<Competency> competencies = repository.findAll();
    LOG.info("Got {} Competency entries from database", competencies.spliterator().estimateSize());
    return competencies;
  }

}
