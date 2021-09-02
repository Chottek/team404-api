package com.team404.kainosproject.service;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.CompetencyIndicator;
import com.team404.kainosproject.model.dto.*;
import com.team404.kainosproject.repository.BandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BandService {

    private static final Logger LOG = LoggerFactory.getLogger(BandService.class);

    private final BandRepository repository;

    @Autowired
    public BandService(BandRepository repository) {
        this.repository = repository;
    }

    /**
     * Gets a List of Band objects from database
     *
     * @return Band objects list
     */
    public Iterable<Band> getAllBands() {
        Iterable<Band> bands = repository.findAll();
        LOG.info("Got {} Band entries from database", bands.spliterator().estimateSize());
        return bands;
    }

    /**
     * Gets a List of Band objects from database and
     * maps it to the BandDTO of form that can be easily parsed
     *
     * @return Iterable of BandDTO objects
     */
    public Iterable<FinalBandDTO> getAllBandsDTOs() {
        Iterable<Band> bands = repository.findAll();
        //List<BandDTO> bandDTOS = new ArrayList<>();

        List<String> competencies = new ArrayList<>();
        List<String> bandNames = new ArrayList<>();

        bands.forEach(e -> {
            /*e.getCompetencyIndicators()
                    .stream()
                    .map(ce -> ce.getSubCompetency().getCompetency().getName())
                    .distinct()
                    .forEach(competencies::add);*/

            e.getCompetencyIndicators()
                    .stream()
                    .filter(ind -> !competencies.contains(ind.getSubCompetency().getCompetency().getName()))
                    .forEach(ind -> competencies.add(ind.getSubCompetency().getCompetency().getName()));

            e.getCompetencyIndicators()
                    .stream()
                    .map(ce -> ce.getBand().getName())
                    .distinct()
                    .forEach(bandNames::add);


            /*List<CompetencyIndicatorDTO> ciDTOS = e.getCompetencyIndicators().stream()
                    .map(ce -> new CompetencyIndicatorDTO(
                            ce.getSubCompetency().getCompetency().getName(),
                            ce.getDescription(),
                            ce.getSubCompetency().getName())).collect(Collectors.toList());

            bandDTOS.add(new BandDTO(e.getName(), ciDTOS));*/
        });

        List<FinalBandDTO> finalBandDTOSList = new ArrayList<>();

        for(String bandName: bandNames){
            FinalBandDTO finalBandDTO = new FinalBandDTO();
            finalBandDTO.setBand(bandName);
            final List<CompetencyDTO> competencyDTOS = new ArrayList<>();
            for(String competency: competencies){
                final List<IndicatorDTO> indicators = new ArrayList<>();
                bands.forEach(e ->
                    e.getCompetencyIndicators()
                            .stream()
                            .filter(s -> s.getSubCompetency().getCompetency().getName().equals(competency))
                            .filter(s -> s.getBand().getName().equals(bandName))
                            .map(cp -> new IndicatorDTO(cp.getSubCompetency().getName(), cp.getDescription()))
                            .forEach(indicators::add));
                if(!indicators.isEmpty()){
                    competencyDTOS.add(new CompetencyDTO(competency, indicators));
                    LOG.info("[{}] BandDTO indicators list contains [{}] entries for competency [{}]", bandName, indicators.size(), competency);
                }else{
                    LOG.error("[{}] BandDTO -> NO ENTRIES FROM competency [{}]", bandName, competency);
                }
            }
            LOG.info("[{}] BandDTO contains [{}] competencies", bandName, competencyDTOS.size());
            finalBandDTO.setCompetencies(competencyDTOS);
            finalBandDTOSList.add(finalBandDTO);
        }
        LOG.info("Created [{}] Band Data Transfer Objects from Band model", finalBandDTOSList.size());
        return finalBandDTOSList;
    }

}

/*for(BandDTO bandDTO: bandDTOS){
            FinalBandDTO finalBand = new FinalBandDTO();
            finalBand.setBand(bandDTO.getName());
            List<CompetencyDTO> competencyDTOS = new ArrayList<>();
            for(String competency : competencies){
                List<IndicatorDTO> indicatorDTOSList = new ArrayList<>();

                List<CompetencyIndicatorDTO> bandsByCompetencyIndicatorName =
                        bandDTO.getCompetencyIndicators().stream().filter(e -> e.getCompetencyIndicatorName().equals(competency)).collect(Collectors.toList());

                for(CompetencyIndicatorDTO cidto: bandsByCompetencyIndicatorName){
                    indicatorDTOSList.add(new IndicatorDTO(cidto.getSubCompetencyName(), cidto.getDescription()));
                }
                competencyDTOS.add(new CompetencyDTO(competency, indicatorDTOSList));
            }
            finalBand.setCompetencies(competencyDTOS);
            finalBandDTOSList.add(finalBand);
        }*/