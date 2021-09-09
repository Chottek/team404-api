package service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.team404.kainosproject.model.Band;
import com.team404.kainosproject.model.Capability;
import com.team404.kainosproject.model.JobFamily;
import com.team404.kainosproject.model.dto.BandJobFamiliesDto;
import com.team404.kainosproject.model.dto.JobFamilyDto;
import com.team404.kainosproject.repository.JobRoleRepository;
import com.team404.kainosproject.service.BandService;
import com.team404.kainosproject.service.CapabilityService;
import com.team404.kainosproject.service.JobFamilyService;
import com.team404.kainosproject.service.JobRoleService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JobRoleServiceTest {

  @Mock
  JobRoleRepository mockJobRoleRepository;

  @Mock
  JobFamilyService mockJobFamilyService;

  @Mock
  BandService mockBandService;

  @Mock
  CapabilityService mockCapabilityService;

  @Mock
  Capability mockCapability;

  @Mock
  JobFamilyDto mockJobFamilyDto1;

  @Mock
  JobFamilyDto mockJobFamilyDto2;

  List<JobFamily> mockJobFamilies = new ArrayList<>();

  List<BandJobFamiliesDto> bandedJobFamilies;

  private void setupMocks() {

    JobFamily mockJobFamily1 = mock(JobFamily.class);
    mockJobFamilies.add(mockJobFamily1);
    JobFamily mockJobFamily2 = mock(JobFamily.class);
    mockJobFamilies.add(mockJobFamily2);

    when(mockJobFamilyService.getAll()).thenReturn(mockJobFamilies);

    // Mock Bands
    Band mockBand1 = mock(Band.class);
    when(mockBand1.getName()).thenReturn("Test Band One");

    Band mockBand2 = mock(Band.class);
    when(mockBand2.getName()).thenReturn("Test Band Two");

    when(mockBandService.getAllBands()).thenReturn(
        new ArrayList<>() {{
          add(mockBand1);
          add(mockBand2);
        }}
    );

    // Mock Capability
    when(mockCapabilityService.getRawCapabilityByName("Test"))
        .thenReturn(Optional.of(mockCapability));

    // When the method attempts to call the job families service we will give it some test data.
    mockJobFamilyDto1 = mock(JobFamilyDto.class);
    when(mockJobFamilyDto1.getJobTitles())
        .thenReturn(
            new ArrayList<>() {{
              add("Test Job One");
            }}
        );

    mockJobFamilyDto2 = mock(JobFamilyDto.class);
    when(mockJobFamilyDto2.getJobTitles())
        .thenReturn(
            new ArrayList<>() {{
              add("Test Job Two");
            }}
        );

    when(mockJobFamilyService.getJobFamiliesByBandAsDto(
        mockJobFamilies,
        mockBand1,
        mockCapability)
    ).thenReturn(
        new ArrayList<>() {{
          add(mockJobFamilyDto1);
        }}
    );

    when(mockJobFamilyService.getJobFamiliesByBandAsDto(
        mockJobFamilies,
        mockBand2,
        mockCapability)
    ).thenReturn(
        new ArrayList<>() {{
          add(mockJobFamilyDto2);
        }}
    );

  }

  @Before
  public void setup() {
    setupMocks();

    JobRoleService test = new JobRoleService(mockJobRoleRepository);
    test.setBandService(mockBandService);
    test.setCapabilityService(mockCapabilityService);
    test.setJobFamilyService(mockJobFamilyService);

    bandedJobFamilies = (List<BandJobFamiliesDto>) test.getJobBandFamilyMatrixByCapability("Test");
  }

  @Test
  public void when_getJobBandFamilyMatrixByCapability_expect_twoTestResults() {
    assertEquals(2, bandedJobFamilies.size());
  }

  @Test
  public void when_getJobBandFamilyMatrixByCapability_expect_groupedByBand() {

    assertAll(
        () -> assertEquals("First band had an unexpected name",
            "Test Band One", bandedJobFamilies.get(0).getBandName()
        ),
        () -> assertEquals("Second band had an unexpected name",
            "Test Band Two", bandedJobFamilies.get(1).getBandName()
        )
    );
  }

  @Test
  public void when_getJobBandFamilyMatrixByCapability_expect_BandsContainTestJobFamilies() {
    assertAll(
        () -> assertEquals("First band had an unexpected job family",
            mockJobFamilyDto1, bandedJobFamilies.get(0).getJobFamilies().get(0)
            // fixme. This is failed, mocked object isnt the same?
        ),
        () -> assertEquals("Second band had an unexpected job family",
            mockJobFamilyDto2, bandedJobFamilies.get(1).getJobFamilies().get(0)
        )
    );
  }

  @Test
  public void when_getJobBandFamilyMatrixByCapability_expect_TestJobFamiliesContainJobRoles() {
    assertAll(
        () -> assertEquals("First band had an unexpected job role",
            "Test Job One", bandedJobFamilies.get(0).getJobFamilies().get(0).getJobTitles().get(0)
        ),
        () -> assertEquals("Second band had an unexpected job role",
            "Test Job Two", bandedJobFamilies.get(1).getJobFamilies().get(0).getJobTitles().get(0)
        )
    );
  }
}