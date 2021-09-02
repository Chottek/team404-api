package com.team404.kainosproject.controller;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.dto.BandDTO;
import com.team404.kainosproject.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BandController {

    private final BandService service;

    @Autowired
    public BandController(BandService service) {
        this.service = service;
    }

    @GetMapping("/bands")
    public Iterable<Band> getAllBands(){
        return service.getAllBands();
    }

    @GetMapping("/bands-competencies")
    public Iterable<BandDTO> getBandDTOs(){
        return service.getAllBandsDTOs();
    }

}
