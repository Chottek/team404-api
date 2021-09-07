package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Capability;
import com.team404.kainosproject.model.dto.CapabilityDto;
import com.team404.kainosproject.repository.CapabilityRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for accessing capability data.
 *
 * @author team404
 */
@Service
public class CapabilityService {

  private CapabilityRepository repository;

  @Autowired
  public CapabilityService(CapabilityRepository repository) {
    this.repository = repository;
  }

  /**
   * get all capabilities as raw data objects.
   */
  protected Iterable<Capability> getAllRaw(){
    return repository.findAll();
  }

  /**
   * get all capabilities as data transfer objects.
   */
  public Iterable<CapabilityDto> getAllDto(){

    return ((List<Capability>) repository.findAll())
        .stream()
        .map(CapabilityDto::new)
        .collect(Collectors.toList());
  }

  /**
   * Transforms a capability model object into it's data transfer object.
   */
  public CapabilityDto getCapabilityAsDto(Capability capability){
    return new CapabilityDto(capability);
  }

  /**
   * get a capability object using it's name.
   * If there are multiple capabilities by this name the first one
   * will be returned.
   */
  public Optional<Capability> getRawCapabilityByName(String name){

    List<Capability> capabilities = repository.findByName(name);

    if(capabilities.size() == 0){
      return Optional.empty();
    }

    return Optional.of(capabilities.get(0));
  }
}