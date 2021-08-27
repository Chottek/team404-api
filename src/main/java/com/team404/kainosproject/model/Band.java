package com.team404.kainosproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "band")
@SecondaryTable(name="competency_indicator", pkJoinColumns = @PrimaryKeyJoinColumn(name="band_id"))
public class Band {

    @Id
    @Column(name = "band_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "competency_id", nullable = false)
    private Competency competency;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Band{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
