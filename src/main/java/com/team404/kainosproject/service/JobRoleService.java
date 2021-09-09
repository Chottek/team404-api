package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.Capability;
import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.dto.BandJobFamiliesDto;
import com.team404.kainosproject.model.dto.JobRoleDto;
import com.team404.kainosproject.repository.JobRoleRepository;
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
public class JobRoleService {

  private static final Logger LOG = LoggerFactory.getLogger(JobRoleService.class);

  private final JobRoleRepository repository;

  private CapabilityService capabilityService;
  private BandService bandService;
  private JobFamilyService jobFamilyService;

  @Autowired
  public JobRoleService(JobRoleRepository repository) {
    this.repository = repository;
  }

  /**
   * Gets a List of JobRole objects from database.
   *
   * @return JobRole objects list
   */
  public Iterable<JobRoleDto> getAllDto() {
    List<JobRole> jobRoles = (List<JobRole>) repository.findAll();
    LOG.info("Got {} JobRole entries from database", jobRoles.spliterator().estimateSize());

    return jobRoles.stream().map(JobRoleDto::new).collect(Collectors.toList());
  }

  /**
   * Gets an Optional of JobRole from database, based on ID.
   *
   * @param id Numeric id of Job Role in database
   * @return Optional of JobRole in database
   */
  public Optional<JobRoleDto> getById(int id) {
    Optional<JobRole> jobRole = repository.findById(id);
    return jobRole.map(JobRoleDto::new).or(Optional::empty);
  }

  /**
   * get a list of job role by their capability, band, and family.
   */
  public List<JobRole> getByCapabilityAndBandAndFamily(JobFamily jobFamily, Band band,
      Capability capability) {
    return repository.findByCapabilityAndBandAndJobFamily(capability, band, jobFamily);
  }

  /**
   * Gets a List of JobFamily objects for a capability and groups them by band.
   *
   * @return JobFamilyDto objects list
   */
  public Iterable<BandJobFamiliesDto> getJobBandFamilyMatrixByCapability(String capabilityName) {

    // Extract Optional Capability
    Optional<Capability> opt = capabilityService.getRawCapabilityByName(capabilityName);

    if (opt.isEmpty()) {
      LOG.warn("search for unrecognised capability " + capabilityName);
      return new ArrayList<>();
    }

    Capability capability = opt.get();
    List<JobFamily> jobFamilies = (List<JobFamily>) jobFamilyService.getAll();
    List<Band> bands = (List<Band>) bandService.getAllBands();

    return bands.stream().map(
        band -> new BandJobFamiliesDto(
            band.getName(),
            jobFamilyService.getJobFamiliesByBandAsDto(jobFamilies, band, capability)
        )
    ).collect(Collectors.toList());
  }

  @Autowired
  public void setCapabilityService(CapabilityService capabilityService) {
    this.capabilityService = capabilityService;
  }

  @Autowired
  public void setBandService(BandService bandService) {
    this.bandService = bandService;
  }

  @Autowired
  public void setJobFamilyService(JobFamilyService jobFamilyService) {
    this.jobFamilyService = jobFamilyService;
  }

  /**
   * Removes a JobRole by given id
   *
   * @param id id of JobRole object to attempt to remove
   * @return true if done, false if not successful
   */
  public boolean removeById(int id) {
    if (repository.findById(id).isPresent()) {
      repository.deleteById(id);
    } else {
      LOG.error("Job Role with id=[{}] doesn't exist!", id);
      return false;
    }

    if (repository.findById(id).isPresent()) {
      LOG.error("Deleting JobRole using id=[{}] wasn't successful ", id);
      return false;
    }

    LOG.info("Successfuly removed JobRole with id=[{}]", id);
    return true;
  }

}
