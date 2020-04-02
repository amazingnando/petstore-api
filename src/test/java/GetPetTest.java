import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class GetPetTest {

    @Before
    public void before () {
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec.setBaseUri("https://petstore.swagger.io/v2");
        spec.addHeader("Content-Type", "application/json");
        RestAssured.requestSpecification = spec.build();
    }

    @Test
    public void getPetById() {
        int id = 1234;
        given()
                .log()
                .all()
                .when ()
                .get("/pet/{id}", id)
                .then()
                .log()
                .all()
                .body("id", is(id))
                .statusCode(200);



    }

    @Test
    public void getPetByStatus() {
        String status = "sold";
        given()
                .log()
                .all()
                .when ()
                .get("/pet/findByStatus?status={status}", status)
                .then()
                .log()
                .all()
                .body("status[0]", is(status))
                .statusCode(200);
    }

    @Test
    public void createPet() {
        String body = "{\n" +
                "  \"id\": 14678,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"SpikeJr\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        given()
                .log()
                .all()
                .body(body)
                .when ()
                .post("/pet")
                .then()
                .log()
                .all()
                .body("id", anyOf(is(body), is(14678)))
                .statusCode(200);
    }

    @Test
    public void updatePet() {
        String body = "{\n" +
                "  \"id\": 14678,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"SpikeJr\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"sold\"\n" +
                "}";
        given()
                .log()
                .all()
                .body(body)
                .when ()
                .put("/pet")
                .then()
                .log()
                .all()
                .body("status", anyOf(is(body), is("sold")))
                .statusCode(200);
    }

    @Test
    public void deletePet() {
        int id = 14678;
        given()
                .log()
                .all()
                .when ()
                .delete("/pet/{id}", id)
                .then()
                .log()
                .all()
                .body("message", is("14678"))
                .statusCode(200);
    }

    @Test
    public void updatePetFormData() {
        int petId = 14678;
        given()
                .log()
                .all()
                .contentType("application/x-www-form-urlencoded")
                .param("name", "max")
                .param("status", "available")
                .when ()
                .post("/pet/{petId}", petId)
                .then()
                .log()
                .all()
                .body("message", is("14678"))
                .statusCode(200);
    }
}