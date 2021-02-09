package com.pnt.api.post;

import com.pnt.api.extentreport.ExtentReportGenerator;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DemoPostStatic extends ExtentReportGenerator {

    @Test
    public void testPost() {
        baseURI = "https://reqres.in/";
        String postEndPoint = "/api/users";

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Russel");
        jsonObject.put("job", "QA engineer");

        given().
                contentType(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                post(postEndPoint).
                then().
                statusCode(201).
                log().all();

    }


}
