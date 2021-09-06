package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.Capability;
import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.dto.BandJobFamiliesDto;
import com.team404.kainosproject.model.dto.JobFamilyDto;
import com.team404.kainosproject.repository.BandRepository;
import com.team404.kainosproject.repository.CapabilityRepository;
import com.team404.kainosproject.repository.JobFamilyRepository;
import com.team404.kainosproject.repository.JobRoleRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
  private BandRepository bandRepository;
  private CapabilityRepository capabilityRepository;
  private JobRoleRepository jobRoleRepository;

  // TODO capability service.

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

  // todo this method actually should now be for JobRoleService instead of job family
  /**
   * Gets a List of JobFamily objects from database
   * and groups them by band.
   *
   * @return JobFamilyDto objects list
   */
  public Iterable<BandJobFamiliesDto> getJobFamiliesForCapabilityByBand(String capabilityName) {

    // Get the capability object
    List<Capability> capabilities = capabilityRepository.findByName(capabilityName);
    LOG.info("Got {} capability entries from database", capabilities.spliterator().estimateSize());

    if(capabilities.size() == 0){
      return new ArrayList<>();
    }

    // Assume capability names are unique ( which they should be )
    Capability capability = capabilities.get(0);

    // Construct the list of bands in order

    List<JobFamily> jobFamilies = (ArrayList<JobFamily>) repository.findAll();
    List<Band> bands = bandRepository.findAll(Sort.by(Direction.ASC, "priority"));

    List<BandJobFamiliesDto> jobFamiliesByBand = new ArrayList<>();

    for (Band band: bands) {

      List<JobFamilyDto> jobFamilyDtos = new ArrayList<>();

      for(JobFamily jobFamily : jobFamilies){

        // This method involves making a lot of requests to the db
        List<JobRole> roles = jobRoleRepository.findByCapabilityAndBandAndJobFamily(
                capability,
                band,
                jobFamily
        );

        jobFamilyDtos.add(
          new JobFamilyDto(jobFamily.getName(), roles)
        );
      }

      jobFamiliesByBand.add(
          new BandJobFamiliesDto(band.getName(), jobFamilyDtos)
      );
    }

    return jobFamiliesByBand;
  }

  @Autowired
  public void setBandRepository(BandRepository bandRepository){
    this.bandRepository = bandRepository;
  }

  @Autowired
  public void setCapabilityRepository(
      CapabilityRepository capabilityRepository) {
    this.capabilityRepository = capabilityRepository;
  }

  @Autowired
  public void setJobRoleRepository(
      JobRoleRepository jobRoleRepository) {
    this.jobRoleRepository = jobRoleRepository;
  }
}
