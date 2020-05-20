package test;

import endPoint.PetEndpoint;
import io.restassured.response.ValidatableResponse;
import model.Category;
import model.Pet;
import model.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CreatePetTest {

    @Steps
    private PetEndpoint petEndpoint;

    private long createdPetId;

    @Test
    public void createPet() {
        Pet pet = Pet.builder()
                .id("0")
                .name("SpikeJr")
                .status(Status.AVAILABLE)
                .category(Category.builder().build())
                .build();
        /*Pet pet = new Pet("0", "SpikeJr", Status.AVAILABLE);*/
        ValidatableResponse response = petEndpoint.createPet(pet);
        createdPetId = response.extract().path("id");
    }

    @After
    public void deletePet() {
        petEndpoint.deletePet(createdPetId);
    }
}
