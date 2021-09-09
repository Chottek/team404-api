package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.Capability;
import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.dto.JobFamilyDto;
import com.team404.kainosproject.repository.JobFamilyRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

  private CapabilityService capabilityService;

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
   * Get a list of job families as data transfer objects.
   */
  public Iterable<JobFamilyDto> getAllAsDto() {
    return ((List<JobFamily>) repository.findAll())
        .stream()
        .map(JobFamilyDto::new)
        .collect(Collectors.toList());
  }

  /**
   * gets a list of JobFamilyDto's by the capability they belong to.
   *
   * @param capabilityName name of the capability to search
   */
  public Iterable<JobFamilyDto> getAllDtoByCapability(String capabilityName) {

    // Extract Optional Capability
    Optional<Capability> opt = capabilityService.getRawCapabilityByName(capabilityName);

    if (opt.isEmpty()) {
      LOG.warn("search for unrecognised capability " + capabilityName);
      return new ArrayList<>();
    }

    Capability capability = opt.get();

    return repository.findByCapability(capability)
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
        jobRoleService.getByCapabilityAndBandAndFamily(jobFamily, band, capability)
    );
  }

  @Autowired
  public void setJobRoleService(JobRoleService jobRoleService) {
    this.jobRoleService = jobRoleService;
  }

  @Autowired
  public void setCapabilityService(CapabilityService capabilityService) {
    this.capabilityService = capabilityService;
  }
}
