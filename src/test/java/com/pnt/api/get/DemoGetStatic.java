package com.pnt.api.get;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DemoGetStatic  {

    @Test(enabled = true)
    public void testSingleUser() {

        baseURI = "https://reqres.in";
        String singlesUserEndPoint = "/api/users/2";

        given().when().
                get(singlesUserEndPoint).
                then().statusCode(200).body("data.id", equalTo(2)).log().all();

    }

    @Test
    public void testListUsers() {

        baseURI = "https://reqres.in";
        String listUserEndPoint = "/api/users?page=2";

        given().when().get(listUserEndPoint).then().
                statusCode(200).
                contentType("application/json").
                body("data[0].first_name", equalTo("Michael")).
                body("total", equalTo(12)).
                body("data.last_name", hasItem("Funke")).
                body("data.last_name", hasItems("Funke", "Lawson")).
                log().all();

    }


}
