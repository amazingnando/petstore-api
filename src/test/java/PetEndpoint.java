import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class PetEndpoint {

    private final static String CREATE_PET = "/pet";
    private final static String GET_PET_BY_ID = "/pet/{id}";
    private final static String GET_PET_BY_STATUS ="/pet/findByStatus?status{status}";
    private final static String UPDATE_PET = "/pet";
    private final static String UPDATE_PET_BY_DATA_FORM = "/pet/{id}";
    private final static String DELETE_PET_BY_ID = "/pet/{id}";

    private RequestSpecification given() {
        return RestAssured
                .given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON)
                .log()
                .all();
    }

    public ValidatableResponse createPet(Pet pet) {
        return given()
                .body(pet)
                .when()
                .post(CREATE_PET)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    public ValidatableResponse getPetById(long petId) {
        return given()
                .when()
                .get(GET_PET_BY_ID, petId)
                .then()
                .log()
                .all()
                .body( "id", anyOf(is(petId), is("available")))
                .statusCode(200);
    }

    public ValidatableResponse getPetByStatus(String status) {
        return given()
                .when()
                .param("status", status)
                .get(GET_PET_BY_STATUS,"/pet/findByStatus")
                .then()
                .log()
                .all()
                .body("status", everyItem(equalTo(status)))
                .statusCode(200);
    }

    public ValidatableResponse updatePet(Pet body) {
        return given()
                .body(body)
                .when()
                .put(UPDATE_PET)
                .then()
                .log()
                .all()
                .body("name", is("Max"))
                .statusCode(200);
    }

    public ValidatableResponse updatePetByDataForm(long petId) {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .param("name", "max")
                .param("status", "sold")
                .when()
                .post(UPDATE_PET_BY_DATA_FORM, petId)
                .then()
                .log()
                .all()
                .body("message", is(String.valueOf(petId)))
                .statusCode(200);
    }

    public ValidatableResponse deletePet(long petId) {
        return given()
                .when()
                .delete(DELETE_PET_BY_ID, petId)
                .then()
                .log()
                .all()
                .body("message", is(String.valueOf(petId)))
                .statusCode(200);
    }


}