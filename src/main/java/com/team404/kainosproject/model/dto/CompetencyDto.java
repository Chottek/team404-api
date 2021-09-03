package com.team404.kainosproject.model.dto;

import java.util.List;

/**
 * A Data Transfer Object representing a Kainos Competency.
 *
 * @author team404
 */
public class CompetencyDto {

  private String name;
  private List<IndicatorDto> indicators;

  public CompetencyDto(String name, List<IndicatorDto> indicators) {
    this.name = name;
    this.indicators = indicators;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<IndicatorDto> getIndicators() {
    return indicators;
  }

  public void setIndicators(List<IndicatorDto> indicators) {
    this.indicators = indicators;
  }
}
