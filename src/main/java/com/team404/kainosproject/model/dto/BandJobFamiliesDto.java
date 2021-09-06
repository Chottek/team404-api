package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.JobFamily;
import java.util.List;

/**
 * A Data Transfer Object representing Job Families grouped by Band.
 *
 * @author team404
 */
public class BandJobFamiliesDto {

  private String bandName;
  private List<JobFamilyDto> jobFamilyDtos;

  public BandJobFamiliesDto(String bandName, List<JobFamilyDto> jobFamilyDtos) {
    this.bandName = bandName;
    this.jobFamilyDtos = jobFamilyDtos;
  }

  public String getBandName() {
    return bandName;
  }

  public List<JobFamilyDto> getJobFamilyDtos() {
    return jobFamilyDtos;
  }

  // Todo we need to get the DTOs here
}
