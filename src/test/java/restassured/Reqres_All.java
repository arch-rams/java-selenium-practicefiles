package restassured;//import static io.restassured.RestAssured;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class Reqres_All extends RestAssuredBase{
/*
    @Test
    public void getRes(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().prettyPrint());
    }
    */

    @Test
    public void getResWithGiven(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);


    }

    @Test
    public void getResWithFW(){
        Response resp = GETRequestResponse.get("api/users");
        System.out.println(resp.statusCode());
        System.out.println(resp.prettyPrint());

    }

    @Test(priority = 0)
    public void getResWithFWnParam(){
        Response resp = GETRequestResponse.get("api/users");
        System.out.println(resp.statusCode());
        System.out.println(resp.prettyPrint());

    }

    public void withAuthOnFW(){
        baseURI = "https://www.hackerrank.com/";
        String token = "9a95ef4eeb739e96e532ebfede1dfe010c7720f1ae2245256e47151c1b0038c5";
        Response response = given()
                .header("Authorization", "Bearer "+ token)
                .get(baseURI+"x/api/v3/tests?limit=10&offset=0")
                .then()
                .statusCode(anyOf(is(401),is(403)))
                .contentType("application/json").extract().response();

        System.out.println("Response is: \n"+response.prettyPrint());


    }

    @Test(enabled = false)
    public void withAuth(){
        baseURI = "https://www.hackerrank.com/";
        String token = "9a95ef4eeb739e96e532ebfede1dfe010c7720f1ae2245256e47151c1b0038c5";
        Response response = given()
                .header("Authorization", "Bearer "+ token)
                .get(baseURI+"x/api/v3/tests?limit=10&offset=0")
                .then()
                .statusCode(anyOf(is(401),is(403)))
                .contentType("application/json").extract().response();

        System.out.println("Response is: \n"+response.prettyPrint());


    }
}
