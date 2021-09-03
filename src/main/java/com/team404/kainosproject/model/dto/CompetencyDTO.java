package com.team404.kainosproject.model.dto;

import java.util.List;

/**
 * A Data Transfer Object representing a Kainos Competency.
 *
 * @author team404
 */
public class CompetencyDTO {

  private String name;
  private List<IndicatorDTO> indicators;

  public CompetencyDTO(String name, List<IndicatorDTO> indicators) {
    this.name = name;
    this.indicators = indicators;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<IndicatorDTO> getIndicators() {
    return indicators;
  }

  public void setIndicators(List<IndicatorDTO> indicators) {
    this.indicators = indicators;
  }
}
