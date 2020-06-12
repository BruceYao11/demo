package com.example.demo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BaiduDemo {
    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;

    @Before
    public void gen() {
        //通用请求
        requestSpecification = new RequestSpecBuilder().build();
        requestSpecification.port(80);
        //通用断言
        responseSpecification = new ResponseSpecBuilder().build();
        responseSpecification.statusCode(200);
    }

    //其他用例里使用
    @Test
    public void testGetHtml(){
        given()
                .spec(requestSpecification)
                .get("http://www.baidu.com")
                .then()
                .spec(responseSpecification);
    }

}
