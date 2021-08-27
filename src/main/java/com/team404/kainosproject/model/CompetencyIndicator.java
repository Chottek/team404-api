package com.team404.kainosproject.model;

import javax.persistence.*;

@Entity
@Table(name = "competency_indicator")
public class CompetencyIndicator {

    @Id
    @Column(name = "competency_indicator_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "sub_competency_id")
    private Integer subCompetencyId;


    @Column(name = "band_id")
    private Integer bandId;

    @Column(name = "description")
    private String description;



}
