package com.example.demo;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestDemo {
    @Test
    public void testGetHtml() {
        given().get("http://www.baidu.com").then().statusCode(200);
        //given().log().all().get("http://www.baidu.com").then().log().all().statusCode(200);
    }

    @Test
    public void testMp3(){
        /**
        given()：一次网络请求所需要的条件都写在这里，头信息、query参数
        when()：触发条件
        then()：断言
        */
        /*given()
                .get("http://www.baidu.com/s?wd=mp3")
                .then().log().all().statusCode(200);*/

        given()
                .queryParam("wd","mp3")
                .when()
                .get("http://www.baidu.com/s")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testSearch() {
        given().log().all()
                .queryParam("code", "sogo")
                .header("Cookie","aliyungf_tc=AQAAAGghcRJ5Wg0AJMyn35gXnYhWI7yf; acw_tc=2760829d15742259268781273ed37b45e28fd67cf874d6c8ea1744a40d7d8e; xq_a_token=5e0d8a38cd3acbc3002589f46fc1572c302aa8a2; xqat=5e0d8a38cd3acbc3002589f46fc1572c302aa8a2; xq_r_token=670668eda313118d7214487d800c21ad0202e141; u=221574225929230; device_id=24700f9f1986800ab4fcc880530dd0ed; Hm_lvt_1db88642e346389874251b5a1eded6e3=1574225930; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1574225930")
       .when()
                .get("https://xueqiu.com/stock/search.json")
                .then()
                .log().all()
                .statusCode(200)
                .body("stocks.name",hasItems("搜狗"))//stocks.name：根节点.子节点
                .body("stocks.code",hasItems("SOGO"))
                .body("stocks.find{it.code == 'SOGO'}.name",equalTo("搜狗"));
    }

}
