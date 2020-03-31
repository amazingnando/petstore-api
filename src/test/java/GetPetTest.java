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

   /* @Test
    public void createPet() {
        String pet = "{ \\\"id\\\": 13567, \\\"category\\\": { \\\"id\\\": 0, \\\"name\\\": \\\"string\\\" }, \\\"name\\\": \\\"doggie4\\\", \\\"photoUrls\\\": [ \\\"string\\\" ], \\\"tags\\\": [ { \\\"id\\\": 0, \\\"name\\\": \\\"string\\\" } ], \\\"status\\\": \\\"available\\\"}";
        given()
                .log().all()
                .baseUri("https://petstore.swagger.io")
                .when ()
                .post("/v2/pet", "Content-Type", "application/json", pet)
                .then()
                .log().all()
                .statusCode(200);
    }*/
}












  /*  @Test
    public void createPet() {

    }*/
