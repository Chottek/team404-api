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

  public CapabilityDto(Capability capability) {

    this.id = capability.getId();
    this.name = capability.getName();
  }

  public CapabilityDto(Integer id, String name,
      List<JobRole> jobRoles, List<JobFamily> jobFamilies) {
    this.id = id;
    this.name = name;
    this.jobRoles = jobRoles;
    this.jobFamilies = jobFamilies;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
