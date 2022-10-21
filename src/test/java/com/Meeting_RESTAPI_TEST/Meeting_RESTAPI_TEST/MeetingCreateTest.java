package com.Meeting_RESTAPI_TEST.Meeting_RESTAPI_TEST;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class MeetingCreateTest {

    @BeforeEach
    void setUp() throws Exception{
        RestAssured.baseURI="http://localhost";
        RestAssured.port=8080;
    }

    @Test
    final void testCreateMeeting(){

        Map<String, Object> meetingDetails = new HashMap<>();
        meetingDetails.put("meetingName", "test");
        meetingDetails.put("responsiblePerson", "Augustinas");
        meetingDetails.put("descriptionMeeting", "testingas");
        meetingDetails.put("categoryMeeting", "live");
        meetingDetails.put("typeMeeting", "testaaasdasdasda");
        meetingDetails.put("startDate", 2022-01);
        meetingDetails.put("endDate", 2022-02);

        Response response = given().
                contentType("application/json").
                accept("application/json").
                body(meetingDetails).
                when().
                post("/meetings").
                then().
                statusCode(200).
                contentType("application/json").
                extract().
                response();

        String meetingId = response.jsonPath().getString("meetingId");
        assertNotNull(meetingId);
    }
}
