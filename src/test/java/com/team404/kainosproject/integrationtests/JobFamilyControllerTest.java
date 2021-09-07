package com.team404.kainosproject.integrationtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static com.team404.kainosproject.integrationtests.JsonTestHelpers.jsonArrayIsNotEmpty;
import static com.team404.kainosproject.integrationtests.JsonTestHelpers.jsonHasAttribute;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobFamilyControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;


  @Test
  public void when_getAllJobFamiliesForCapability_expect_resultContainsSomeJobFamilies(){

    JSONArray jobFamilies = new JSONArray(restTemplate
        .getForEntity(createURLWithPort("/job-family/Engineering"), String.class)
        .getBody());


    assertTrue(jobFamilies.length() > 0);
    assertTrue( jsonHasAttribute((JSONObject) jobFamilies.get(0), "jobFamilyName"));
    assertTrue( jsonHasAttribute((JSONObject) jobFamilies.get(0), "jobTitles"));
  }

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }
}
