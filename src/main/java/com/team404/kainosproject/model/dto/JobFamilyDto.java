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

  private String jobFamilyName;
  private List<String> jobTitles;

  /**
   * Creates a new JobFamilyDTO with a selection of jobs.
   *
   * @param familyName name of the family
   * @param jobs selection of jobs to place in the family dto
   */
  public JobFamilyDto(String familyName, List<JobRole> jobs) {
    this.jobFamilyName = familyName;
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
    this.jobFamilyName = jobFamily.getName();
    this.jobTitles = new ArrayList<>();

    jobFamily.getJobRoles().forEach( jobRole -> {
      this.jobTitles.add(jobRole.getTitle());
    });
  }

  public String getJobFamilyName() {
    return jobFamilyName;
  }

  public List<String> getJobTitles() {
    return jobTitles;
  }
}
