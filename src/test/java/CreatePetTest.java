import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class CreatePetTest {

    PetEndpoint petEndpoint = new PetEndpoint();

    long createdPetId;

    @Test
    public void createPet() {
        Pet pet = new Pet("0", "SpikeJr", "available");
        ValidatableResponse response = petEndpoint.createPet(pet);
        createdPetId = response.extract().path("id");
    }

    @After
    public void deletePet() {
        petEndpoint.deletePet(createdPetId);
    }
}
