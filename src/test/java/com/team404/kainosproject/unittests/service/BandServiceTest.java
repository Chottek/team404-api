package com.team404.kainosproject.unittests.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.Competency;
import com.team404.kainosproject.model.CompetencyIndicator;
import com.team404.kainosproject.model.SubCompetency;
import com.team404.kainosproject.model.dto.BandCompetenciesDto;
import com.team404.kainosproject.repository.BandRepository;
import com.team404.kainosproject.service.BandService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BandServiceTest {

  // Is this technically testing BandService, BandDto, CompetencyDto and IndicatorDto...

  // Todo create a list of mock bands

  // todo create a mock of a BandRepository where find all will return the list of mocks

  // todo initialize a band service with this mock repository then test

  @Mock
  Band mockBand1;
  @Mock
  Band mockBand2;

  @Mock
  CompetencyIndicator mockIndicator1;
  @Mock
  CompetencyIndicator mockIndicator2;

  @Mock
  SubCompetency mockSubCompetency;

  @Mock
  Competency mockCompetency;

  @Mock
  BandRepository bandRepository;

  @Test
  public void when_getAllBandDtos_expect_correctDTOsAreCreated(){

    // todo extract mock to set up

    // Mock two bands to test with
    when(mockBand1.getName()).thenReturn("test band one");
    when(mockBand2.getName()).thenReturn("test band two");

    when(mockBand1.getCompetencyIndicators()).thenReturn(
        new ArrayList<>(){{
          add(mockIndicator1);
        }}
    );

    when(mockBand2.getCompetencyIndicators()).thenReturn(
        new ArrayList<>(){{
          add(mockIndicator2);
        }}
    );

    // Mock an indicators
    when(mockIndicator1.getDescription()).thenReturn("test indicator one");
    when(mockIndicator1.getBand()).thenReturn(mockBand1);
    when(mockIndicator1.getSubCompetency()).thenReturn(mockSubCompetency);

    when(mockIndicator2.getDescription()).thenReturn("test indicator two");
    when(mockIndicator2.getBand()).thenReturn(mockBand2);
    when(mockIndicator2.getSubCompetency()).thenReturn(mockSubCompetency);

    // Mock a sub-competency
    when(mockSubCompetency.getName()).thenReturn("test sub competency");
    when(mockSubCompetency.getCompetency()).thenReturn(mockCompetency);

    // Mock an indicator
    when(mockCompetency.getName()).thenReturn("test competency");

    // Mock a repository which will return the mock bands
    when(bandRepository.findAll()).thenReturn(new ArrayList<>(){{
      add(mockBand1);
      add(mockBand2);
    }});

    BandService testService = new BandService(bandRepository);
    List<BandCompetenciesDto> result = (ArrayList<BandCompetenciesDto>) testService.getAllBandsDtos();

    // should match structure of JSON with

    // todo extract assertions to method

    assertAll(
      () -> assertEquals("First test band had an unexpected name",
          "test band one", result.get(0).getBand()
      ),
      () -> assertEquals("Second test band had an unexpected name",
          "test band two", result.get(1).getBand()
      ),

      () -> assertEquals("First test band had an unexpected competency name",
          "test competency", result.get(0).getCompetencies().get(0).getName()
      ),
      () -> assertEquals("Second test band had an unexpected competency name",
          "test competency", result.get(1).getCompetencies().get(0).getName()
      ),

      () -> assertEquals("First test band had an unexpected sub-competency name",
          "test sub competency", result.get(0).getCompetencies().get(0).getIndicators().get(0).getName()
      ),
      () -> assertEquals("Second test band had an unexpected sub-competency name",
          "test sub competency", result.get(1).getCompetencies().get(0).getIndicators().get(0).getName()
      ),

      () -> assertEquals("First test band had an unexpected indicator description",
          "test indicator one", result.get(0).getCompetencies().get(0).getIndicators().get(0).getDescription()
      ),
      () -> assertEquals("Second test band had an unexpected indicator description",
          "test indicator two", result.get(1).getCompetencies().get(0).getIndicators().get(0).getDescription()
      )
    );

    /* Expected is
      [
        {
            'band' : 'test band one',
            'competencies' : [
                {
                    'name' : 'test competency',
                    'indicators' :
                    [
                        {'name' : 'test sub competency', 'description' : "test indicator one"}, {'name' : 'test sub competency', 'description' : "test indicator two"},
                        ...
                    ]
                },
                ...
            ]
        },
        { 'band' : 'test band two', ... },    -- Above competencies repeats in band 2
      ]
      ...
    ]
  */

  }

  @Test
  public void when_NoBandsToGetDtos_expect_emptyResult(){

    when(bandRepository.findAll()).thenReturn(new ArrayList<>());

    BandService testService = new BandService(bandRepository);
    List<BandCompetenciesDto> result = (ArrayList<BandCompetenciesDto>) testService.getAllBandsDtos();

    assertEquals("Had a result even though no bands were given",0, result.size());
  }
}