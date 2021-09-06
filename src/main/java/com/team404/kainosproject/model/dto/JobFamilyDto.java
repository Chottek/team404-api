package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.JobRole;
import java.util.ArrayList;
import java.util.List;

/**
 * Data transfer object abstracting a job family.
 *
 * @author team404
 */
public class JobFamilyDto {

  private String familyName;
  private List<String> jobTitles;

  /**
   * Creates a new JobFamilyDTO with a selection of jobs.
   *
   * @param familyName name of the family
   * @param jobs selection of jobs to place in the family dto
   */
  public JobFamilyDto(String familyName, List<JobRole> jobs) {
    this.familyName = familyName;
    this.jobTitles = new ArrayList<>();

    jobs.forEach( job -> {
      this.jobTitles.add(job.getTitle());
    });
  }

  /**
   * Creates a new JobFamilyDTO with all jobs in that family.
   *
   * @param jobFamily the family to create the DTO for
   */
  public JobFamilyDto(JobFamily jobFamily) {
    this.familyName = jobFamily.getName();
    this.jobTitles = new ArrayList<>();

    jobFamily.getJobRoles().forEach( jobRole -> {
      this.jobTitles.add(jobRole.getTitle());
    });
  }

  public String getFamilyName() {
    return familyName;
  }

  public List<String> getJobTitles() {
    return jobTitles;
  }
}
