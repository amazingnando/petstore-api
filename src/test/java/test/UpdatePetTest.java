package test;

import endPoint.PetEndpoint;
import io.restassured.response.ValidatableResponse;
import model.Category;
import model.Pet;
import model.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UpdatePetTest {

    @Steps
    private PetEndpoint petEndpoint;

    long createdPetId;

    @Before
    public void createPet() {
        Pet pet = Pet.builder()
                .id("0")
                .name("SpikeJr")
                .status(Status.AVAILABLE)
                .category(Category.builder().build())
                .build();
        ValidatableResponse response = petEndpoint.createPet(pet);
        createdPetId = response.extract().path("id");
    }


    @Test
    public void updatePet() {
        Pet pet = Pet.builder()
                .id("0")
                .name("Max")
                .status(Status.SOLD)
                .category(Category.builder().build())
                .build();
        petEndpoint.updatePet(pet);
    }

    @After
    public void deletePet() {
        petEndpoint.deletePet(createdPetId);
    }
}
