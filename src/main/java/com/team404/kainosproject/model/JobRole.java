package com.team404.kainosproject.model;

import com.team404.kainosproject.model.dto.JobRoleDto;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

/**
 * Job Role.
 *
 * @author team404
 */
@Entity
@Table(name = "job_role")
@SecondaryTable(name = "job_detail", pkJoinColumns = @PrimaryKeyJoinColumn(name = "job_id"))
public class JobRole {

  public JobRole(){

  }

  public JobRole(JobRoleDto dto){
    this.title = dto.getTitle();
    this.description = dto.getDescription();
    this.contractType = dto.getContractType();
    this.responsibilities = dto.getResponsibilities();
    this.sharePointLink = dto.getSharepointLink();
  }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="job_id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="description", table = "job_detail")
    private String description;

    @Column(name="contractType")
    private String contractType;

    @Column(name = "posted")
    private String posted;

    @Column(name = "responsibilities")
    private String responsibilities;

    @ManyToMany
    @JoinTable(
            name = "job_location",
            joinColumns = @JoinColumn(name="job_id"),
            inverseJoinColumns = @JoinColumn(name="location_id")
    )
    List<Location> locations;

    @ManyToOne
    @JoinColumn(name="capability_id")
    private Capability capability;

    @ManyToOne
    @JoinColumn(name="job_family_id")
    private JobFamily jobFamily;

  @ManyToOne
  @JoinColumn(name = "band_id", nullable = false)
  private Band band;

  @Column(name = "sharepoint_link")
  private String sharePointLink;

  public String getCapability() {
    return capability.getName();
  }

  public String getSharePointLink() {
    return sharePointLink;
  }

    public List<Location> getLocations() {
        return locations;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContractType() {
        return contractType;
    }

//    public Band getBand() {
//        return band;
//    }

    public JobFamily getJobFamily() {
        return jobFamily;
    }

  public String getBandAsString() {
    return band.getName();
  }

  public String getPosted() {
    return posted;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setContractType(String contractType) {
    this.contractType = contractType;
  }

  public void setPosted(String posted) {
    this.posted = posted;
  }

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }

  public void setCapability(Capability capability) {
    this.capability = capability;
  }

  public void setJobFamily(JobFamily jobFamily) {
    this.jobFamily = jobFamily;
  }

  public void setBand(Band band) {
    this.band = band;
  }

  public void setSharePointLink(String sharePointLink) {
    this.sharePointLink = sharePointLink;
  }

  public String getResponsibilities() {
    return responsibilities;
  }

  public void setResponsibilities(String responsibilities) {
    this.responsibilities = responsibilities;
  }

  @Override
  public String toString() {
    return "JobRole{"
        + "id=" + id
        + ", title='" + title + '\''
        + ", description='" + description + '\''
        + ", contractType='" + contractType + '\''
        + '}';
  }
}
