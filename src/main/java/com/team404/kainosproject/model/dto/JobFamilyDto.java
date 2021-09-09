package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.Capability;
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

  private final String jobFamilyName;
  private final List<String> jobTitles;
  private final CapabilityDto capability;

  /**
   * Creates a new JobFamilyDTO with a selection of jobs.
   *
   * @param familyName name of the family
   * @param jobs       selection of jobs to place in the family dto
   */
  public JobFamilyDto(String familyName, List<JobRole> jobs, Capability capability) {
    this.jobFamilyName = familyName;
    this.jobTitles = new ArrayList<>();

    jobs.forEach(job -> {
      this.jobTitles.add(job.getTitle());
    });

    this.capability = new CapabilityDto(capability);
  }

  /**
   * Creates a new JobFamilyDTO with all jobs in that family.
   *
   * @param jobFamily the family to create the DTO for
   */
  public JobFamilyDto(JobFamily jobFamily) {
    this.jobFamilyName = jobFamily.getName();
    this.jobTitles = new ArrayList<>();

    jobFamily.getJobRoles().forEach(jobRole -> {
      this.jobTitles.add(jobRole.getTitle());
    });

    this.capability = new CapabilityDto(jobFamily.getCapability());
  }

  public String getJobFamilyName() {
    return jobFamilyName;
  }

  public List<String> getJobTitles() {
    return jobTitles;
  }

  public String getCapabilityName() {
    return capability.getName();
  }
}
