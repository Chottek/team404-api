package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.Capability;
import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.model.dto.JobFamilyDto;
import com.team404.kainosproject.repository.JobFamilyRepository;
import com.team404.kainosproject.service.JobFamilyService;
import com.team404.kainosproject.service.JobRoleService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JobFamilyServiceTest {

  @Mock
  JobRoleService mockJobRoleService;

  @Mock
  JobFamilyRepository mockRepository;

  @Mock
  List<JobFamily> mockJobFamilies;

  @Mock
  Band mockBand;

  @Mock
  Capability mockCapability;


  List<JobFamilyDto> JobFamiliesByBand;

  private void setupMocks() {

    JobFamily mockJobFamily1 = mock(JobFamily.class);
    when(mockJobFamily1.getName()).thenReturn("Test Job Family One");

    JobFamily mockJobFamily2 = mock(JobFamily.class);
    when(mockJobFamily2.getName()).thenReturn("Test Job Family Two");

    mockJobFamilies = new ArrayList<>() {{
      add(mockJobFamily1);
      add(mockJobFamily2);
    }};

    JobRole mockJobRole1 = mock(JobRole.class);
    when(mockJobRole1.getTitle()).thenReturn("Test Job One");
    JobRole mockJobRole2 = mock(JobRole.class);
    when(mockJobRole2.getTitle()).thenReturn("Test Job Two");

    // Job Role 1 is the same band and capability, but in family 1
    when(mockJobRoleService.getByCapabilityAndBandAndFamily(
        mockJobFamily1,
        mockBand,
        mockCapability)
    ).thenReturn(
        new ArrayList<>() {{
          add(mockJobRole1);
        }}
    );

    // Job Role 1 is the same band and capability, but in family 2
    when(mockJobRoleService.getByCapabilityAndBandAndFamily(
        mockJobFamily2,
        mockBand,
        mockCapability)
    ).thenReturn(
        new ArrayList<>() {{
          add(mockJobRole2);
        }}
    );

  }

  @Before
  public void getSetup() {
    setupMocks();

    JobFamilyService test = new JobFamilyService(mockRepository);
    test.setJobRoleService(mockJobRoleService);

    JobFamiliesByBand = test.getJobFamiliesByBandAsDto(mockJobFamilies, mockBand, mockCapability);
  }

  @Test
  public void when_getJobFamiliesByBandAsDto_Expect_TwoTestResults() {
    assertEquals("Unexpected number of results", 2, JobFamiliesByBand.size());
  }

  @Test
  public void when_getJobFamiliesByBandAsDto_Expect_ResultsGroupedByFamily() {

    assertAll(
        () -> assertEquals("Expected first result to be first test family",
            "Test Job Family One", JobFamiliesByBand.get(0).getJobFamilyName()
        ),

        () -> assertEquals("Expected second result to be second test family",
            "Test Job Family Two", JobFamiliesByBand.get(1).getJobFamilyName()
        )
    );
  }

  @Test
  public void when_getJobFamiliesByBandAsDto_Expect_ResultsContainTestJobs() {
    assertAll(
        () -> assertTrue("expected first result to contain test job one",
            JobFamiliesByBand.get(0).getJobTitles().contains("Test Job One")
        ),

        () -> assertTrue("expected second result to contain test job two",
            JobFamiliesByBand.get(1).getJobTitles().contains("Test Job Two")
        )
    );
  }
}