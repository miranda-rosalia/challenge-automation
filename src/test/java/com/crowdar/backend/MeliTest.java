package com.crowdar.backend;

import com.crowdar.model.Department;
import org.testng.annotations.Test;
//import static io.restassured.RestAssured.given;

import java.util.List;

public class MeliTest {
    final static String baseURL="https://www.mercadolibre.com.ar/menu/"; // Configuration
    @Test
    public void sussessDepartments(){ getDepartments();}

    public void getDepartments(){
       /* List<Department> listBooks  =  given()
                .header("Content-type", "application/json")
                .when()
                .get(baseURL+"departments")
                .then()
                .extract()
                .body()
                .jsonPath().getList(".",Department.class);*/
    }
}
