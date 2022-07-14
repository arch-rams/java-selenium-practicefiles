package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class RestAssuredBase {
    RestAssuredBase(){
        //RestAssured.baseURI = "https://reqres.in/";
        RestAssured.baseURI = "https://www.hackerrank.com/";
    }
    public static RequestSpecification setLogs(){
        RequestLogSpecification rlog = null;
        rlog = RestAssured
                .given()
                .log();
        return  rlog.all().contentType(ContentType.JSON);
    }
}
