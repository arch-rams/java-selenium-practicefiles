package restassured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.Map;

public class GETRequestResponse extends  RestAssuredBase {
    public static Response get(){
        return setLogs().get();
    }

    public static Response get(String resource) {
        return setLogs().when().get(RestAssured.baseURI+ resource);
    }
    public static Response getWithHeader(Map<String, String> headers, String URL) {
        return setLogs()
                .when()
                .headers(headers)
                .get(URL);
    }

    public static Response getWithHeader(Header header, String URL) {

        return setLogs()
                .when()
                .header(header)
                .get(URL);
    }
}
