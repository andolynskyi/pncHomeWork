package step_definitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Scanner;

public class SimpleTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        do {
            System.out.println("Enter your city");
            String resource = scanner.nextLine();

            String endPoint = "https://restcountries.com/v3.1/capital/" + resource;

            Response response = RestAssured.get(endPoint);

            System.out.println(response.statusCode());
            System.out.println(response.asString());

            System.out.println("Continue?");
            answer = scanner.nextLine();
        } while (!answer.equalsIgnoreCase("no"));
    }

}
