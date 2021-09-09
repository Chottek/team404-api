package com.team404.kainosproject.integrationtests;

import static com.team404.kainosproject.integrationtests.JsonTestHelpers.jsonArrayIsNotEmpty;
import static com.team404.kainosproject.integrationtests.JsonTestHelpers.jsonHasAttribute;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

// https://spring.io/guides/gs/testing-web/

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobRoleControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;
  private JSONArray jobMatrixEngineering;

  @Before
  public void setup() {
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
        () -> assertEquals("full_time", firstObj.get("contractType")),
        () -> assertEquals("Test Link", firstObj.get("sharePointLink"))
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

    JSONArray jobRoles = new JSONArray(restTemplate
        .getForEntity(createURLWithPort("/job-roles"), String.class)
        .getBody());

    // this assumes return is in ID order
    int maxId = jobRoles.getJSONObject(jobRoles.length() - 1).getInt("id");

    assertAll("Should return 404 Status",
        () -> assertEquals("-1 is an invalid job role id but did not return 404",
            ResponseEntity.notFound().build().getStatusCode(),
            restTemplate.getForEntity(createURLWithPort("/job-roles/" + (-1)), String.class)
                .getStatusCode()
        ),

        () -> assertEquals("0 is an invalid job role id but did not return 404",
            ResponseEntity.notFound().build().getStatusCode(),
            restTemplate.getForEntity(createURLWithPort("/job-roles/" + (0)), String.class)
                .getStatusCode()
        ),

        () -> assertEquals((maxId + 1) + " is out of the range of job ids but did not return 404",
            ResponseEntity.notFound().build().getStatusCode(),
            restTemplate.getForEntity(createURLWithPort("/job-roles/" + (maxId + 1)), String.class)
                .getStatusCode()
        )
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
        });
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


  /**
   * (First, the object of ID has to be in Database!) Check if on attempt of removing an existing
   * object from database, Response returns 200 OK status code
   */
  @Test
  public void when_request_ExistingJobRoleDeletion_Expect_OKResponse() {
    final int ID = 1;

    ResponseEntity<Void> exchange = restTemplate.exchange(createURLWithPort("/remove-role/" + ID),
        HttpMethod.DELETE, null, Void.class);
    assertEquals(200, exchange.getStatusCode().value());
  }

  /**
   * Check if on attempt of removing non-existing object from database, Response returns 400 Bad
   * Request status code
   */
  @Test
  public void when_request_NonExistingJobRoleDeletion_Expect_BadRequestResponse() {
    final int ID = -1;

    ResponseEntity<Void> exchange = restTemplate.exchange(createURLWithPort("/remove-role/" + ID),
        HttpMethod.DELETE, null, Void.class);
    assertEquals(400, exchange.getStatusCode().value());
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


  /**
   * Check if String of "responsibilities" column from JobRole object got by ID is not an empty
   * String.
   */
  @Test
  public void when_getJobById_expect_responsibilitiesToBe_NonEmpty() {
    final int ID = 1;
    final JSONObject jobRole = new JSONObject(restTemplate
        .getForEntity(createURLWithPort("/job-roles/" + ID), String.class)
        .getBody());

    assertFalse(jobRole.get("responsibilities").toString().isEmpty());
  }


  @Test
  public void when_requestJobRoleMatrix_Expect_JobRolesAndFamiliesReturned() {

    System.out.println(jobMatrixEngineering);

    // Check each band has family and job titles
    jobMatrixEngineering.forEach(band -> {

      assertAll(
          () -> assertTrue("a band had no attribute \"bandName\"",
              jsonHasAttribute((JSONObject) band, "bandName")),
          () -> assertTrue("a band had no attribute \"jobFamilies\"",
              jsonHasAttribute((JSONObject) band, "jobFamilies")),
          () -> assertTrue("a band " + band + " contained no jobFamilies",
              jsonArrayIsNotEmpty((JSONObject) band, "jobFamilies"))
      );
    });

    jobMatrixEngineering.forEach(band -> {

      JSONArray jobFamilies = ((JSONObject) band).getJSONArray("jobFamilies");

      jobFamilies.forEach(family -> {

        assertAll(
            () -> assertTrue("a family had no attribute \"jobFamilyName\"",
                jsonHasAttribute((JSONObject) family, "jobFamilyName")),
            () -> assertTrue("a family had no attribute \"jobTitles\"",
                jsonHasAttribute((JSONObject) family, "jobTitles"))
        );

      });
    });
  }

  @Test
  public void when_requestJobRoleMatrix_Expect_ReturnedInOrderOfBand() {

    // This test will need improving when admin users are given the ability to create new bands

    String[] bandOrder = {"Executive", "Leadership", "Principal", "Manager", "Consultant",
        "Senior_Associate", "Associate", "Trainee", "Apprentice"};

    for (int i = 0; i < bandOrder.length; i++) {

      assertEquals(
          "Band order mis-matching",
          bandOrder[i],
          jobMatrixEngineering.getJSONObject(i).get("bandName")
      );

    }

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