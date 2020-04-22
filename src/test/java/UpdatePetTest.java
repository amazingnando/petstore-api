import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class UpdatePetTest {

    PetEndpoint petEndpoint = new PetEndpoint();

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
