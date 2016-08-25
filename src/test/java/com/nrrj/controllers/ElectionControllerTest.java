package com.nrrj.controllers;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Sql(value= {"/prepare-db.sql"})
public class ElectionControllerTest {
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
                .get("/api/elections")
                .then().log().all()
                .statusCode(200)
                .body(
                        "numberOfElements", is(1),
                        "totalElements", is(1),
                        "totalPages", is(1),
                        "content[0].name", equalTo("November 2017"),
                        "content[0].id", is(1)
                );

    }
}