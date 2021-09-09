package com.team404.kainosproject.integrationtests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BandControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  private JSONArray bandsCompetenciesResult;

  @Before
  public void setUp() {
    bandsCompetenciesResult = new JSONArray(restTemplate
        .getForEntity(createURLWithPort("/bands-competencies"), String.class)
        .getBody());
  }

  @Test
  public void when_getBands_Expect_NotEmptyResultSet() {
    assertTrue(bandsCompetenciesResult.length() > 0);
  }

  @Test
  public void when_getBands_Expect_BandFieldAndCompetenciesArray_IsPresent() {
    for (Object band : bandsCompetenciesResult) {
      final JSONObject obj = (JSONObject) band;
      assertAll(
          () -> assertTrue("[band] field is missing from object " + obj,
              isPresentInObject(obj, "band")),
          () -> assertTrue("[competencies] array is missing from object " + obj,
              isPresentInObject(obj, "competencies")),
          () -> assertTrue("[competencies] array is empty in object " + obj,
              isHavingEntries(obj.getJSONArray("competencies")))
      );
    }
  }

  @Test
  public void when_getBands_Expect_EachCompetencyHas_NameAndIndicatorsArray() {
    for (Object band : bandsCompetenciesResult) {
      final JSONObject obj = (JSONObject) band;

      obj.getJSONArray("competencies").forEach((competency) -> {
            JSONObject competencyObj = (JSONObject) competency;

            if (!isPresentInObject(competencyObj, "name")) {
              fail("Object: " + competencyObj + " had no name attribute");
            }

            if (!isPresentInObject(competencyObj, "indicators")) {
              fail("Object: " + competencyObj + " had no attribute indicators");
            }

            if (!isHavingEntries(competencyObj.getJSONArray("indicators"))) {
              fail("Object: " + competencyObj + " had a zero length list of indicators");
            }
          }
      );
    }
  }

  @Test
  public void when_getBands_ExpectEachCompetencyIndicator_Contains_NonEmpty_NameAndDescription() {
    for (Object band : bandsCompetenciesResult) {
      final JSONObject obj = (JSONObject) band;
      JSONArray competencies = obj.getJSONArray("competencies");
      competencies.forEach((competency) -> {
        JSONObject competencyJSONObject = (JSONObject) competency;
        JSONArray indicators = (JSONArray) competencyJSONObject.get("indicators");
        indicators.forEach((indicator) -> {
          JSONObject indicatorObj = (JSONObject) indicator;
          if (!isPresentInObject(indicatorObj, "name")) {
            fail("Indicator: " + indicatorObj + " had no attribute name");
          }

          if (indicatorObj.get("name").toString().length() == 0) {
            fail("[" + indicatorObj.getString("name")
                + "]'s description field had an empty String!");
          }

          if (!isPresentInObject(indicatorObj, "description")) {
            fail("Indicator: " + indicatorObj + " had no attribute description");
          }

          if (indicatorObj.get("description").toString().length() == 0) {
            fail("[" + indicatorObj.getString("name")
                + "]'s description field had an empty String!");
          }
        });
      });
    }
  }

  @Test
  public void when_GetBandNames_ExpectList_ToBe_NotNullNotEmpty() {
    String s = restTemplate.getForEntity(createURLWithPort("/bands"), String.class).getBody();
    assertFalse("Result of Band Names query is empty!", s == null && s.isEmpty());
  }

  private boolean isPresentInObject(JSONObject obj, String fieldName) {
    try {
      obj.get(fieldName);
    } catch (JSONException je) {
      return false;
    }
    return true;
  }

  private boolean isHavingEntries(JSONArray arr) {
    return arr.length() > 0;
  }

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }
}
