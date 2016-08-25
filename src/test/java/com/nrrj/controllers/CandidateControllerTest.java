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
public class CandidateControllerTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.port = 8001;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    // GET /api/candidates
    public void shouldShowPage0() throws Exception {
        given().log().all().and().given()
                .get("/api/candidates")
                .then().log().all()
                .statusCode(200)
                .body(
                        "numberOfElements", is(3),
                        "totalElements", is(6),
                        "totalPages", is(2),
                        "content[0].name", equalTo("Hilary Clinton"),
                        "content[0].id", is(1)
                        );

    }

    @Test
    // DELETE /api/candidates/:id
    public void shouldDeleteCandidate() throws Exception {
        given().log().all().and().given().
                delete("/api/candidates/3")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    // PUT /api/candidates/:id
    public void shouldUpdateCandidate() throws Exception {
        Map<String, Object> json = new HashMap<>();
        json.put("name", "Rilley");
        json.put("party", "REPUBLICAN");

        given().log().all().and().given().
                contentType(ContentType.JSON).
                body(json).
                put("/api/candidates/6")
                .then().log().all()
                .statusCode(200)
                .body(
                        "name", equalTo("Rilley"),
                        "party", equalTo("REPUBLICAN")
                );
    }

    @Test
    // PUT /api/candidates/:id/addVote
    public void shouldAddVoteToCandidate() throws Exception {
        Map<String, Object> json = new HashMap<>();
        json.put("id", "2");

        given().log().all().and().given().
                contentType(ContentType.JSON).
                body(json).
                put("/api/candidates/1/addVote")
                .then().log().all()
                .statusCode(200)
                .body(
                        "name", equalTo("Hilary Clinton"),
                        "voters[0].id", equalTo(2)
                );
    }

   @Test
    // GET /api/candidates/:id/voters
    public void shouldShowVotersByCandidate() throws Exception {
        given().log().all().and().given()
                .get("/api/candidates/2/voters")
                .then().log().all()
                .statusCode(200);

    }

}