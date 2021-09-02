package com.team404.kainosproject.integrationtests;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BandControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void when_getBands_Expect_NotEmptyResultSet() {
        final JSONArray result = new JSONArray(restTemplate
                .getForEntity(createURLWithPort("/bands-competencies"), String.class)
                .getBody()
        );

        assertTrue(result.length() > 0);
    }

    @Test
    public void when_getBands_Expect_AllBandsAndCompetenciesAreReturned() {
        final JSONArray result = new JSONArray(restTemplate
                .getForEntity(createURLWithPort("/bands-competencies"), String.class)
                .getBody()
        );

        // TODO Refactor each test into their own function

        System.out.println(result.spliterator().estimateSize());

        for (Object band : result) {

            JSONObject obj = (JSONObject) band;

            System.out.println(band.toString());
            System.out.println("______________");

            assertAll(
                    // Check the band is labelled
                    () -> {
                        try {
                            obj.get("band");
                        } catch (JSONException e) {
                            fail("Object: " + obj + " was missing a management level (band)");
                        }
                    },

                    // Contains a list of competencies of non-zero length
                    () -> {
                        try {
                            JSONArray arr = (JSONArray) obj.get("competencies");
                            if (arr.length() <= 0) fail("Object: " + obj + " has no competencies listed");

                        } catch (JSONException e) {
                            fail("Object: " + obj + " has no competencies attribute");
                        }
                    },

                    // Check all competencies have a name and set of indicators of non-zero length
                    () -> {
                        JSONArray arr = (JSONArray) obj.get("competencies");
                        arr.forEach(
                                (competency) -> {
                                    JSONObject competencyObj = (JSONObject) competency;
                                    try {
                                        competencyObj.get("name");
                                    } catch (JSONException e) {
                                        fail("Object: " + competencyObj + " had no name attribute");
                                    }

                                    try {
                                        JSONArray indicators = (JSONArray) competencyObj.get("indicators");
                                        assertTrue(
                                                "Object: " + competencyObj + " had a zero length list of indicators",
                                                indicators.length() > 0
                                        );
                                    } catch (JSONException e) {
                                        fail("object: " + competencyObj + " had no attribute indicators");
                                    }
                                }
                        );
                    },

                    // Check that each competency indicator has a name and description
                    () -> {
                        // For each competency
                        JSONArray competencies = (JSONArray) obj.get("competencies");
                        competencies.forEach((competency) -> {

                            // Foreach Indicator
                            JSONObject competencyObj = new JSONObject(competency);
                            JSONArray indicators = (JSONArray) competencyObj.get("indicators");
                            indicators.forEach((indicator) -> {

                                JSONObject indicatorObj = (JSONObject) indicator;
                                try {
                                    indicatorObj.get("name");
                                } catch (JSONException e) {
                                    fail("Indicator: " + indicatorObj + " had no attribute name");
                                }

                                try {
                                    String desc = (String) indicatorObj.get("description");
                                    assertTrue(
                                            "Indicator: " + indicatorObj + "had an empty description",
                                            desc.length() > 0
                                    );
                                } catch (JSONException e) {
                                    fail("Indicator: " + indicatorObj + " had no attribute description");
                                }
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
