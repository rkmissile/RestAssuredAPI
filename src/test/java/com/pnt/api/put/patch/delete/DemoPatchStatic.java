package com.pnt.api.put.patch.delete;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DemoPatchStatic {

    @Test
    public void test01() {


        baseURI = "https://reqres.in/";
        String patchEndPoint = "/api/users";

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Russel");
        jsonObject.put("job", "QA engineer");

        given().
                contentType(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                patch(patchEndPoint).
                then().
                statusCode(200).
                log().all();

    }

}
