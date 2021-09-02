package com.team404.kainosproject.model.dto;

import java.util.List;

public class BandDTO {

    private String band;
    private List<CompetencyDTO> competencies;

    public BandDTO(String band, List<CompetencyDTO> competencies) {
        this.band = band;
        this.competencies = competencies;
    }

    public BandDTO() {
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public List<CompetencyDTO> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(List<CompetencyDTO> competencies) {
        this.competencies = competencies;
    }
}
