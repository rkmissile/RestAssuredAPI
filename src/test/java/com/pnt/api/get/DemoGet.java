package com.pnt.api.get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoGet {

    @Test
    public void test01() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        int statusCode = response.getStatusCode();
        //      System.out.println( response.getBody());
//       System.out.println(response.asString());
//        System.out.println(response.getContentType());
        System.out.println(response.getHeaders().asList());

        Assert.assertEquals(200, statusCode);

    }

    @Test
    public void test02() {

        RestAssured.baseURI = "https://reqres.in";

        String singlesUserEndPoint = "/api/users/2";

        // Response response = RestAssured.get( );

        RestAssured.given().
                when().
                get(singlesUserEndPoint).
                then().
                statusCode(200);

    }


}
