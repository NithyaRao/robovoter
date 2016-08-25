package com.nrrj.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Sql(value= {"/prepare-db.sql"})
public class VoterControllerTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.port = 8001;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    // GET /api/voters
    public void shouldShowPage0() throws Exception {
        given().log().all().and().given()
                .get("/api/voters")
                .then().log().all()
                .statusCode(200)
                .body(
                        "numberOfElements", is(3),
                        "totalElements", is(6),
                        "totalPages", is(2),
                        "content[0].name", equalTo("Bob"),
                        "content[0].id", is(1)
                );

    }

    @Test
    // GET /api/voters/{id}/candidate
    public void shouldShowWhodidVoterVoteFor() throws Exception {
        given().log().all().and().given()
                .get("/api/voters/1/candidate")
                .then().log().all()
                .statusCode(200)
                .body(
                        "numberOfElements", is(1),
                        "totalElements", is(1),
                        "totalPages", is(1),
                        "content[0].name", equalTo("Alice Smith"),
                        "content[0].id", is(6)
                );

    }
}