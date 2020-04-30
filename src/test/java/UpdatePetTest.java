import io.restassured.response.ValidatableResponse;
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
        Pet pet = new Pet("0", "SpikeJr", Status.AVAILABLE);
        ValidatableResponse response = petEndpoint.createPet(pet);
        createdPetId = response.extract().path("id");
    }


    @Test
    public void updatePet() {
        Pet updatedPet = new Pet(String.valueOf(createdPetId), "Max", Status.SOLD);
        ValidatableResponse response = petEndpoint.updatePet(updatedPet);
    }

    @After
    public void deletePet() {
        petEndpoint.deletePet(createdPetId);
    }
}
