package com.team404.kainosproject.model.dto;

public class CompetencyIndicatorDTO {

    private String competencyIndicatorName;
    private String description;
    private String subCompetencyName;

    public CompetencyIndicatorDTO(String competencyIndicatorName, String description, String subCompetencyName) {
        this.competencyIndicatorName = competencyIndicatorName;
        this.description = description;
        this.subCompetencyName = subCompetencyName;
    }

    public String getCompetencyIndicatorName() {
        return competencyIndicatorName;
    }

    public void setCompetencyIndicatorName(String competencyIndicatorName) {
        this.competencyIndicatorName = competencyIndicatorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubCompetencyName() {
        return subCompetencyName;
    }

    public void setSubCompetencyName(String subCompetencyName) {
        this.subCompetencyName = subCompetencyName;
    }
}