package com.pnt.api.put.patch.delete;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DemoDeleteStatic {

    @Test
    public void test01() {

        baseURI = "https://reqres.in/";
        String deleteEndPoint = "/api/users/2";


        given().
                when().
                delete(deleteEndPoint).
                then().
                statusCode(204).
                log().all();

    }


}
