package com.team404.kainosproject.model.dto;

import java.util.List;

/**
 * A Data Transfer Object representing Job Families grouped by Band.
 *
 * @author team404
 */
public class BandJobFamiliesDto {

  private final String bandName;
  private final List<JobFamilyDto> jobFamilies;

  public BandJobFamiliesDto(String bandName, List<JobFamilyDto> jobFamilyDtos) {
    this.bandName = bandName;
    this.jobFamilies = jobFamilyDtos;
  }

  public String getBandName() {
    return bandName;
  }

  public List<JobFamilyDto> getJobFamilies() {
    return jobFamilies;
  }

  // Todo we need to get the DTOs here
}
