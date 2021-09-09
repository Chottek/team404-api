package com.team404.kainosproject.model.dto;

import java.util.List;

/**
 * A Data Transfer Object abstracting the Band (Management Level) object.
 *
 * @author team404
 */
public class BandCompetenciesDto {

  private String band;
  private List<CompetencyDto> competencies;

  public BandCompetenciesDto(String band, List<CompetencyDto> competencies) {
    this.band = band;
    this.competencies = competencies;
  }

  public BandCompetenciesDto() {
  }

  public String getBand() {
    return band;
  }

  public void setBand(String band) {
    this.band = band;
  }

  public List<CompetencyDto> getCompetencies() {
    return competencies;
  }

  public void setCompetencies(List<CompetencyDto> competencies) {
    this.competencies = competencies;
  }
}
