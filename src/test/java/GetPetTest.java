import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetPetTest {

    @Test
    public void getPetById() {
        int id = 1;
        given()
                .log().all()
                .baseUri("https://petstore.swagger.io")
                .when ()
                .get("/v2/pet/{id}", id)
                .then()
                .log().all()
                .statusCode(200);



    }

    @Test
    public void getPetByStatus() {
        String status = "sold";
        given()
                .log().all()
                .baseUri("https://petstore.swagger.io")
                .when ()
                .get("/v2/pet/findByStatus?status={status}", status)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void createPet() {
        String ContentType = "application/json";
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
                .log().all()
                .baseUri("https://petstore.swagger.io")
                .contentType(ContentType)
                .body(body)
                .when ()
                .post("/v2/pet")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updatePet() {
        String ContentType = "application/json";
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
                .log().all()
                .baseUri("https://petstore.swagger.io")
                .contentType(ContentType)
                .body(body)
                .when ()
                .put("/v2/pet")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void deletePet() {
        int id = 14678;
        given()
                .log().all()
                .baseUri("https://petstore.swagger.io")
                .when ()
                .delete("/v2/pet/{id}", id)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updatePetFormData() {
        String ContentType = "application/x-www-form-urlencoded";
        int petId = 123;
        given()
                .log().all()
                .baseUri("https://petstore.swagger.io")
                .contentType(ContentType)
                .param("name", "johny")
                .param("status", "available")
                .when ()
                .post("/v2/pet/{petId}", petId)
                .then()
                .log().all()
                .statusCode(200);
    }
}






