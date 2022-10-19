package step_definitions;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class SimpleTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        do {
            System.out.println("Enter your city");
            String resource = scanner.nextLine().toLowerCase();

            String endPoint = "https://restcountries.com/v3.1/capital/" + resource;

            Response response = RestAssured.get(endPoint);

            System.out.println(response.statusCode());
            System.out.println(response.asString());

            JsonPath jsonPath = response.jsonPath();
            String capital = jsonPath.getString("capital[0].get(0)").toLowerCase();
            System.out.println(capital);

            Assert.assertEquals("Status code NOT 200", 200, response.statusCode());
            Assert.assertEquals("Capital city not equal", resource, capital);

            System.out.println("Continue?");
            answer = scanner.nextLine();
        } while (!answer.equalsIgnoreCase("no"));
    }

}
