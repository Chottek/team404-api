package com.team404.kainosproject.model.dto;

import java.util.List;

public class BandDTO {

    private String name;
    private List<CompetencyIndicatorDTO> competencyIndicators;
    private List<String> competencyIndicatorNames;

    public BandDTO(String name, List<CompetencyIndicatorDTO> competencyIndicators) {
        this.name = name;
        this.competencyIndicators = competencyIndicators;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CompetencyIndicatorDTO> getCompetencyIndicators() {
        return competencyIndicators;
    }

    public void setCompetencyIndicators(List<CompetencyIndicatorDTO> competencyIndicators) {
        this.competencyIndicators = competencyIndicators;
    }
}

