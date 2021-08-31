package com.team404.kainosproject.model;

<<<<<<< HEAD
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="job_role")
@SecondaryTable(name="job_detail", pkJoinColumns = @PrimaryKeyJoinColumn(name="job_id"))
public class JobRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="job_id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="description", table = "job_detail")
    private String description;

    @Column(name="contractType")
    private String contractType;

    @ManyToMany
    @JoinTable(
            name = "job_location",
            joinColumns = @JoinColumn(name="job_id"),
            inverseJoinColumns = @JoinColumn(name="location_id")
    )
    private List<Location> locations;

    @Column(name = "sharepoint_link")
    private String sharePointLink;

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

    @Override
    public String toString() {
        return "JobRole{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", contractType='" + contractType + '\'' +
                '}';
    }
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Job Role.
 *
 * @author team404
 */
@Entity
@Table(name = "job_role")
public class JobRole {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "job_id")
  private Integer id;

  @Column(name = "title")
  private String title;

  @Column(name = "contractType")
  private String contractType;

  @Column(name = "posted")
  private String posted;

  public String getPosted() {
    return posted;
  }

  public Integer getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContractType() {
    return contractType;
  }

  @Override
  public String toString() {
    return "JobRole{"
        + "id=" + id
        + ", title='" + title + '\''
        + ", contractType='" + contractType + '\''
        + ", posted='" + posted + '\''
        + '}';
  }
>>>>>>> master
}
