package com.team404.kainosproject.integrationtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

// https://spring.io/guides/gs/testing-web/

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobRoleControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

    private JSONArray jobMatrixEngineering;

    @BeforeClass
    private void setup() {
        jobMatrixEngineering = new JSONArray(restTemplate
            .getForEntity(createURLWithPort("/job-matrix/Engineering"), String.class)
            .getBody()
        );
    }

  @Test
  public void when_gettingFirstRowFromJobRoleTable_Expect_ReturnsTestJobRow() {
    final JSONArray jobRoles = new JSONArray(restTemplate
        .getForEntity(createURLWithPort("/job-roles"), String.class)
        .getBody());

    final JSONObject firstObj = (JSONObject) jobRoles.get(0);

    assertAll("Should contain Test Job Row",
        () -> assertEquals("Head of test job", firstObj.get("title")),
        () -> assertEquals("full_time", firstObj.get("contractType"))
    );
  }

  @Test
  public void when_gettingJobSpecificationByID_Expect_TestRowLocationsAndDescription() {
    final JSONObject jobRole = new JSONObject(restTemplate
        .getForEntity(createURLWithPort("/job-roles/" + 1), String.class)
        .getBody());

    assertAll("Should contain Test Job Row",
        () -> assertEquals("Head of test job", jobRole.get("title")),
        () -> assertEquals(
            "[{\"name\":\"London\"},{\"name\":\"Birmingham\"},{\"name\":\"Gdansk\"}]",
            jobRole.getJSONArray("locations").toString()
        ),
        () -> assertEquals(3, jobRole.getJSONArray("locations").length()),
        () -> assertEquals("<b>What you will be expected to do </b> " +
                "<br/> Day to day you will be expected to be a test entry in our tables.",
            jobRole.get("description")),
        () -> assertEquals("full_time", jobRole.get("contractType"))
    );
  }

  @Test
  public void when_wrongIDForJobSpecification_Expect_JobSpecificationNotFound() {
    final int jobRolesSize = new JSONArray(restTemplate
        .getForEntity(createURLWithPort("/job-roles"), String.class)
        .getBody()).length();

    assertAll("Should return 404 Status",
        () -> assertEquals(restTemplate
            .getForEntity(createURLWithPort("/job-roles/" + (-1)), String.class)
            .getStatusCode(), ResponseEntity.notFound().build().getStatusCode()),

        () -> assertEquals(restTemplate
            .getForEntity(createURLWithPort("/job-roles/" + (0)), String.class)
            .getStatusCode(), ResponseEntity.notFound().build().getStatusCode()),

        () -> assertEquals(restTemplate
            .getForEntity(createURLWithPort("/job-roles/" + (jobRolesSize + 1)), String.class)
            .getStatusCode(), ResponseEntity.notFound().build().getStatusCode())
    );
  }

  @Test
  public void when_getJobSpecification_Expect_JobCapabilityIsReturned() {
    final JSONObject jobRole = new JSONObject(restTemplate
        .getForEntity(createURLWithPort("/job-roles/" + 1), String.class)
        .getBody());

    assertEquals("Engineering", jobRole.get("capability"));
  }

  @Test
  public void when_getAllJobs_Expect_AllReturnACapability() {

    final JSONArray jobRoles = new JSONArray(restTemplate
        .getForEntity(createURLWithPort("/job-roles"), String.class)
        .getBody()
    );

    jobRoles.forEach(
        (jobRole) -> {
          try {
            ((JSONObject) jobRole).get("capability");
          } catch (JSONException e) {
            fail("Object " + jobRole + " is missing a capability");
          }
        }
    );
  }

  @Test
  public void when_getJobSpecification_Expect_JobBandIsReturned() {
    final JSONObject jobRole = new JSONObject(restTemplate
        .getForEntity(createURLWithPort("/job-roles/" + 1), String.class)
        .getBody());
    assertEquals("Leadership", jobRole.get("band"));
  }

  @Test
  public void when_getAllJobs_Expect_AllReturnABand() {

    final JSONArray jobRoles = new JSONArray(restTemplate
        .getForEntity(createURLWithPort("/job-roles"), String.class)
        .getBody()
    );

    jobRoles.forEach(
        (jobRole) -> {
          try {
            ((JSONObject) jobRole).get("band");
          } catch (JSONException e) {
            fail("Object " + jobRole + " is missing a band");
          }
        }
    );
  }

  @Test
  public void when_requestJobRoleMatrix_Expect_JobRolesAndFamiliesReturned() {

    // Check each band has family and job titles
    jobMatrixEngineering.forEach(band -> {

      assertAll(
          () -> assertTrue(jsonHasAttribute((JSONObject) band, "band_name")),
          () -> assertTrue(jsonHasAttribute((JSONObject) band, "job_families")),
          () -> assertTrue(jsonArrayIsNotEmpty((JSONObject) band, "job_families"))
      );
    });

    jobMatrixEngineering.forEach(band -> {

      JSONArray jobFamilies = ((JSONObject) band).getJSONArray("job_families");

      jobFamilies.forEach(family -> {

        assertAll(
            () -> assertTrue(jsonHasAttribute((JSONObject) family, "job_family_name")),
            () -> assertTrue(jsonHasAttribute((JSONObject) family, "job_titles")),
            () -> assertTrue(jsonArrayIsNotEmpty((JSONObject) family, "job_titles"))
        );

      });
    });
  }

  @Test
  public void when_requestJobRoleMatrix_Expect_ReturnedInOrderOfBand() {

  }

  private boolean jsonArrayIsNotEmpty(JSONObject json, String arrayName) {

    try {

        if (json.getJSONArray(arrayName).length() >= 0) {
            return false;
        }
    } catch (JSONException e) {
      return false;
    }

    return true;
  }

  private boolean jsonHasAttribute(JSONObject json, String attributeName) {

    try {
      json.get(attributeName);
    } catch (JSONException e) {
      return false;
    }

    return true;
  }

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }

}