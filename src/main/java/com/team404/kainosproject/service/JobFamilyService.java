package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.Capability;
import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.dto.JobFamilyDto;
import com.team404.kainosproject.repository.JobFamilyRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Job Role Service.
 *
 * @author team404
 */
@Service
public class JobFamilyService {

  private static final Logger LOG = LoggerFactory.getLogger(JobRoleService.class);

  private final JobFamilyRepository repository;

  // This is a circular dependency
  private JobRoleService jobRoleService;

  @Autowired
  public JobFamilyService(JobFamilyRepository repository) {
    this.repository = repository;
  }

  /**
   * Gets a List of JobFamily objects from database.
   *
   * @return JobFamily objects list
   */
  public Iterable<JobFamily> getAll() {
    Iterable<JobFamily> jobFamilies = repository.findAll();
    LOG.info("Got {} Job Family entries from database", jobFamilies.spliterator().estimateSize());
    return jobFamilies;
  }

  /**
   * Get all Job Family Objects from data base as
   * Data transfer objects.
   */
  public Iterable<JobFamilyDto> getAllAsDto() {
    return ((List<JobFamily>) repository.findAll())
        .stream()
        .map(JobFamilyDto::new)
        .collect(Collectors.toList());
  }

  /**
   * Groups Job roles of the same band and capability by job family.
   *
   * @param jobFamilies Families to group roles by
   * @param band        the band which all job roles in the list belong to
   * @param capability  the capability of the job families
   * @return a list of created job families as Data transfer objects
   */
  public List<JobFamilyDto> getJobFamiliesByBandAsDto(List<JobFamily> jobFamilies, Band band,
      Capability capability) {

    return jobFamilies
        .stream()
        .map(
            family -> getJobFamilyDtoByCapabilityAndBandAndFamily(family, band, capability)
        )
        .collect(Collectors.toList());
  }

  // todo this should call a job service method, not the repository

  /**
   * Creates a job family dto consisting of all jobs of the same capability, band and job family.
   */
  private JobFamilyDto getJobFamilyDtoByCapabilityAndBandAndFamily(JobFamily jobFamily, Band band,
      Capability capability) {

    return new JobFamilyDto(
        jobFamily.getName(),
        jobRoleService.getByCapabilityAndBandAndFamily(jobFamily, band, capability),
        capability
    );
  }

  @Autowired
  public void setJobRoleService(JobRoleService jobRoleService) {
    this.jobRoleService = jobRoleService;
  }
}
