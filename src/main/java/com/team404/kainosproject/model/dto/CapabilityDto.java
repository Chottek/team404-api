package com.team404.kainosproject.model.dto;

import com.team404.kainosproject.model.Capability;
import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.JobRole;
import java.util.List;

/**
 * Abstraction of a capability model object.
 *
 * @author team404
 */
public class CapabilityDto {

  private final Integer id;

  private final String name;

  private List<JobRole> jobRoles;

  private List<JobFamily> jobFamilies;

  /**
   * Create a new data transfer object from a capability model objet.
   */
  public CapabilityDto(Capability capability) {

    this.id = capability.getId();
    this.name = capability.getName();
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
