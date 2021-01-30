package com.pnt.api.put.patch.delete;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DemoPutStatic {

    @Test
    public void testPut() {

        baseURI = "https://reqres.in/";
        String putEndPoint = "/api/users/2";

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Russel");
        jsonObject.put("job", "QA engineer");

        given().
                contentType(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                put(putEndPoint).
                then().
                statusCode(200).
                log().all();

    }


}
