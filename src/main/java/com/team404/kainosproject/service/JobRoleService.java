package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.Capability;
import com.team404.kainosproject.model.ContractType;
import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.Location;
import com.team404.kainosproject.model.dto.JobRoleDto;
import com.team404.kainosproject.repository.BandRepository;
import com.team404.kainosproject.repository.CapabilityRepository;
import com.team404.kainosproject.repository.JobFamilyRepository;
import com.team404.kainosproject.repository.JobRoleRepository;
import com.team404.kainosproject.repository.LocationRepository;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.format.annotation.DateTimeFormat;
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
  private final CapabilityRepository capRepository;
  private final JobFamilyRepository jfRepository;
  private final BandRepository bandRepository;
  private final LocationRepository locationRepository;

  @Autowired
  public JobRoleService(JobRoleRepository repository, CapabilityRepository capRepository,
      JobFamilyRepository jfRepository, BandRepository bandRepository, LocationRepository locationRepository) {
    this.repository = repository;
    this.capRepository = capRepository;
    this.jfRepository = jfRepository;
    this.bandRepository = bandRepository;
    this.locationRepository = locationRepository;
  }

  /**
   * Gets a List of JobRole objects from database.
   *
   * @return JobRole objects list
   */
  public Iterable<JobRole> getAll() {
    Iterable<JobRole> jobRoles = repository.findAll();
    LOG.info("Got {} JobRole entries from database", jobRoles.spliterator().estimateSize());
    return jobRoles;
  }

  /**
   * Gets an Optional of JobRole from database, based on ID.
   *
   * @param id Numeric id of Job Role in database
   * @return Optional of JobRole in database
   */
  public Optional<JobRoleDto> getById(int id) {
    Optional<JobRole> jobRole = repository.findById(id);
    if(jobRole.isPresent()){
      LOG.info("Got JobRole object with id=[{}]", id);
      return Optional.of(new JobRoleDto(jobRole.get()));
    }else{
      LOG.error("No JobRole object with id=[{}]", id);
      return Optional.empty();
    }
  }


  /**
   * Add JobRole to repository after field validation
   *
   * @param role JobRoleDto object containing necessary fields
   * @throws WrongEntityFieldException Thrown when there's an error during validation
   */
  public void addJobRole(JobRoleDto role) throws WrongEntityFieldException {
    StringBuilder errorMessage = new StringBuilder();
    LOG.info("Got a POST for JobRole with title=[{}]", role.getTitle());
    JobRole newRole = new JobRole();

    if(role.getTitle() == null || role.getTitle().isEmpty()){
      errorMessage.append("Title should not be null nor empty!\n");
    }else{
      newRole.setTitle(role.getTitle());
    }

    if(role.getDescription() == null || role.getDescription().isEmpty()){
      errorMessage.append("Description should not be null nor empty!\n");
    }else{
      newRole.setDescription(role.getDescription());
    }

    if(Arrays.stream(ContractType.values()).noneMatch((t) -> t.name().equals(role.getContractType()))){
      errorMessage.append("Contract Type ").append(role.getContractType())
          .append(" doesn't match any Contract Types ")
          .append(Arrays.toString(ContractType.values())).append("\n");

    }else{
      newRole.setContractType(role.getContractType());
    }

    newRole.setPosted(String.valueOf(new Timestamp(System.currentTimeMillis())));

    if(role.getResponsibilities() == null || role.getResponsibilities().isEmpty()){
      errorMessage.append("Responsibilities should not be null nor empty!\n");
    }else{
      newRole.setResponsibilities(role.getResponsibilities());
    }

    //Locations
    if(role.getLocations() == null || role.getLocations().size() == 0){
      errorMessage.append("Locations should not be null nor empty!");
    }else{
      List<Location> locationList = new ArrayList<>();
      for(Location l: locationRepository.findAll()){
        for(String locationString : role.getLocations()){
          if(l.getName().equals(locationString)){
            locationList.add(l);
          }
        }
      }
      newRole.setLocations(locationList);
    }

    //Capability
    Optional<Capability> capability = capRepository.getByName(role.getCapability());
    if(capability.isPresent()){
      newRole.setCapability(capability.get());
    }else{
      errorMessage.append("Capability of name ").append(role.getCapability())
          .append(" doesn't exist!\n");
    }

    //JobFamily
    Optional<JobFamily> jobFamily = jfRepository.getByName(role.getJobFamily());
    if(jobFamily.isPresent()){
      newRole.setJobFamily(jobFamily.get());
    }else{
      errorMessage.append("Job Family of name ").append(role.getJobFamily())
          .append(" doesn't exist!\n");
    }
    //Band
    Optional<Band> band = bandRepository.getByName(role.getBand());
    if(band.isPresent()){
      newRole.setBand(band.get());
    }else{
      errorMessage.append("Band of name ").append(role.getBand()).append(" doesn't exist!\n");
    }

    if(role.getSharepointLink() == null || role.getSharepointLink().isEmpty()){
      errorMessage.append("SharePoint link should not be null nor empty!\n");
    }
    newRole.setSharePointLink(role.getSharepointLink());

    if(!errorMessage.toString().isEmpty()){
      LOG.error("[POST JobRole] -> {}", errorMessage);
      throw new WrongEntityFieldException(errorMessage.toString());
    }

    repository.save(newRole);
  }

}
