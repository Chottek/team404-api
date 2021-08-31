package com.team404.kainosproject.intergrationtests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

// https://spring.io/guides/gs/testing-web/

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobRoleControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;


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
