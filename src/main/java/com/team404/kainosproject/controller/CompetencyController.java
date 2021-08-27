package com.team404.kainosproject.controller;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.service.BandedCompetencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompetencyController {

    private final BandedCompetencyService service;

    @Autowired
    public CompetencyController(BandedCompetencyService service) {
        this.service = service;
    }

    @GetMapping("/competencies")
    public Iterable<Band> getAllCompetencies(){
        return service.getAllCompetenciesByBand();
    }


}
