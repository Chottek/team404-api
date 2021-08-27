package com.team404.kainosproject.integrationtests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import org.json.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

// https://spring.io/guides/gs/testing-web/

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobRoleControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void when_gettingFirstRowFromJobRoleTable_Expect_ReturnsTestJobRow(){
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
    public void when_gettingJobSpecificationByID_Expect_TestRowLocationsAndDescription(){
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
    public void when_wrongIDForJobSpecification_Expect_JobSpecificationNotFound(){
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
    public void when_getJobSpecification_Expect_JobCapabilityIsReturned(){
        final JSONObject jobRole = new JSONObject(restTemplate
                .getForEntity(createURLWithPort("/job-roles/" + 1), String.class)
                .getBody());

        assertEquals("Engineering", (String) jobRole.get("capability"));
    }

    @Test
    public void when_getAllJobs_Expect_AllReturnACapability(){

        final JSONArray jobRoles = new JSONArray(restTemplate
                .getForEntity(createURLWithPort("/job-roles"), String.class)
                .getBody()
        );

        jobRoles.forEach(
                (jobRole) -> {
                    try{
                        ((JSONObject) jobRole).get("capability");
                    }
                    catch (JSONException e){
                        fail("Object " + jobRole + " is missing a capability");
                    }
                }
        );
    }

    @Test
    public void when_getJobSpecification_Expect_JobBandIsReturned(){
        final JSONObject jobRole = new JSONObject(restTemplate
                .getForEntity(createURLWithPort("/job-roles/" + 1), String.class)
                .getBody());

        assertEquals("Associate", (String) jobRole.get("band"));
    }

    @Test
    public void when_getAllJobs_Expect_AllReturnABand(){

        final JSONArray jobRoles = new JSONArray(restTemplate
                .getForEntity(createURLWithPort("/job-roles"), String.class)
                .getBody()
        );

        jobRoles.forEach(
                (jobRole) -> {
                    try{
                        ((JSONObject) jobRole).get("band");
                    }
                    catch (JSONException e){
                        fail("Object " + jobRole + " is missing a band");
                    }
                }
        );
    }

    @Test
    public void when_getBands_Expect_AllBandsAndCompetenciesAreReturned(){

        final JSONArray result = new JSONArray(restTemplate
                .getForEntity(createURLWithPort("/management-levels"), String.class)
                .getBody()
        );

         /*
         Expected
         [
            {
                'band' : 'Apprentice',
                'competencies' : [
                    {
                        'name' : 'Personal_Performance',
                        'indicators' :
                        [
                            {'name' : 'Developing self-awareness', 'name' : '...', 'description' : "..."}, {'description' : "..."},
                            ...
                        ]
                    },
                    ...
                ]
            },
            { 'band' : 'Trainee', ... },
            ...
         ]
         */

        // Expect 8 Bands
        assertEquals(8, result.length());

        // Expect Each management level to have one or more competency

        // TODO Refactor each test into their own function
        for (Object band: result) {

            JSONObject obj = (JSONObject) band;

            assertAll(

                    // Check the band is labelled
                    () -> {
                        try{
                            obj.get("band");
                        } catch (JSONException e){
                            fail("Object: " + obj + " was missing a management level (band)");
                        }
                    },

                    // Contains a list of competencies of non-zero length
                    () -> {
                        try{
                            JSONArray arr = (JSONArray) obj.get("competencies");
                            if(arr.length() <= 0) fail("Object: " + obj + " has no competencies listed");

                        } catch (JSONException e){
                            fail("Object: " + obj + " has no competencies attribute");
                        }
                    },

                    // Check all competencies have a name and set of indicators of non-zero length
                    () -> {
                        JSONArray arr = (JSONArray) obj.get("Competencies");

                        arr.forEach(
                                (competency) -> {
                                    JSONObject competencyObj = new JSONObject(competency);
                                    try { competencyObj.get("name"); }
                                    catch (JSONException e) { fail("Object: " + competencyObj + " had no name attribute"); }

                                    try {
                                        JSONArray indicators = (JSONArray) competencyObj.get("indicators");
                                        assertTrue(
                                                "Object: " + competencyObj + " had a zero length list of indicators",
                                                indicators.length() > 0
                                        );
                                    }
                                    catch (JSONException e) {
                                        fail("object: " + competencyObj + " had no attribute indicators");
                                    }
                                }
                        );
                    },

                    // Check that each competency indicator has a name and description
                    () -> {

                        // For each competency
                        JSONArray competencies = (JSONArray) obj.get("Competencies");
                        competencies.forEach( (competency) -> {

                            // Foreach Indicator
                            JSONObject competencyObj = new JSONObject(competency);
                            JSONArray indicators = (JSONArray) competencyObj.get("indicators");
                            indicators.forEach( (indicator) -> {

                                JSONObject indicatorObj = (JSONObject) indicator;
                                try{ indicatorObj.get("name"); }
                                catch (JSONException e) { fail("Indicator: " + indicatorObj + " had no attribute name"); }

                                try{
                                    String desc = (String) indicatorObj.get("description");
                                    assertTrue(
                                            "Indicator: " + indicatorObj + "had an empty description",
                                            desc.length() > 0
                                    );
                                }
                                catch (JSONException e) { fail("Indicator: " + indicatorObj + " had no attribute description"); }
                            });
                        });
                    }
            );
        }
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}

/* TODO This starts the server on a random port to test the full application
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SomeTestClass {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void SomeTest() throws Exception{

        restTemplate.getForObject();

    }

}
*/

// To test just a data source it seems we can use @MockBean to mock a repository.

/* Using Mock MVC tests the requests without starting a full web application

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class JobRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void SomeTest() throws Exception{
        mockMVC.perform(...)
    }

}
 */
