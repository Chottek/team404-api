package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.Capability;
import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.dto.BandJobFamiliesDto;
import com.team404.kainosproject.repository.BandRepository;
import com.team404.kainosproject.repository.CapabilityRepository;
import com.team404.kainosproject.repository.JobFamilyRepository;
import com.team404.kainosproject.repository.JobRoleRepository;
import com.team404.kainosproject.service.JobFamilyService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@RunWith(MockitoJUnitRunner.class)
public class JobFamilyServiceTest {

  @Mock
  CapabilityRepository mockCapabilityRepository;
  @Mock
  Capability mockCapability;

  @Mock
  BandRepository mockBandRepository;
  @Mock
  Band mockBand1;
  @Mock
  Band mockBand2;

  @Mock
  JobFamilyRepository mockJobFamilyRepository;
  @Mock
  JobFamily mockJobFamily;

  @Mock
  JobRoleRepository mockJobRoleRepository;
  @Mock
  JobRole mockJobRole1;
  @Mock
  JobRole mockJobRole2;

  private void setupMockBands(){

    when(mockBand1.getName()).thenReturn("test Band 1");
    when(mockBand2.getName()).thenReturn("test Band 2");

    when(mockBandRepository.findAll(Sort.by(Direction.ASC, "priority"))).thenReturn(new ArrayList<>(){{
      add(mockBand1);
      add(mockBand2);
    }});
  }

  private void setupMockCapability(){

    when(mockCapabilityRepository.findByName("Test"))
        .thenReturn(new ArrayList<>(){{
          add(mockCapability);
        }});
  }

  private void setupMockJobFamily(){

    when(mockJobFamily.getName())
        .thenReturn("Test Job Family");

    when(mockJobFamilyRepository.findAll())
        .thenReturn(new ArrayList<>(){{
          add(mockJobFamily);
        }});
  }

  private void setupMockJobRoles(){

    when(mockJobRole1.getTitle()).thenReturn("Test Job role 1");
    when(mockJobRole2.getTitle()).thenReturn("Test Job role 2");

    when(mockJobRoleRepository.findByCapabilityAndBandAndJobFamily(
        mockCapability, mockBand1, mockJobFamily
    )).thenReturn(new ArrayList<>(){{
      add(mockJobRole1);
    }});

    when(mockJobRoleRepository.findByCapabilityAndBandAndJobFamily(
        mockCapability, mockBand2, mockJobFamily
    )).thenReturn(new ArrayList<>(){{
      add(mockJobRole2);
    }});
  }

  private void setupMocks(){
    setupMockBands();
    setupMockCapability();
    setupMockJobFamily();
    setupMockJobRoles();
  }

  // todo when refactoring JobFamiliesService, split this test method across the created separate methods.

  @Test
  public void when_getJobFamiliesForCapabilityByBand_expect_allBandsAndJobFamiliesReturned() {

    setupMocks();

    // todo assert that the DTO's constructors are called?
    JobFamilyService service = new JobFamilyService(mockJobFamilyRepository);
    service.setCapabilityRepository(mockCapabilityRepository);
    service.setBandRepository(mockBandRepository);
    service.setJobRoleRepository(mockJobRoleRepository);

    List<BandJobFamiliesDto> result = (ArrayList<BandJobFamiliesDto>) service.getJobFamiliesForCapabilityByBand("Test");

    checkJobFamiliesBandStructure(result);
  }

  private void checkJobFamiliesBandStructure(List<BandJobFamiliesDto> jobFamilyBands) {

    // todo these messages arnt great, as if anything is wrong with the structure its likely there will be ann exception.

    assertEquals("First band had an unexpected name",
        "test Band 1", jobFamilyBands.get(0).getBandName()
    );
    assertEquals("Second band had an unexpected name",
        "test Band 2", jobFamilyBands.get(1).getBandName()
    );

    assertEquals("First band had an unexpected job family",
        "Test Job Family", jobFamilyBands.get(0).getJobFamilies().get(0).getJobFamilyName()
    );
    assertEquals("Second band had an unexpected job family",
        "Test Job Family", jobFamilyBands.get(1).getJobFamilies().get(0).getJobFamilyName()
    );

    assertEquals("First band had an unexpected job role",
        "Test Job role 1", jobFamilyBands.get(0).getJobFamilies().get(0).getJobTitles().get(0)
    );
    assertEquals("Second band had an unexpected job role",
        "Test Job role 2", jobFamilyBands.get(1).getJobFamilies().get(0).getJobTitles().get(0)
    );

    // todo expected JSON Structure
  }

}