import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

public class DeletePetTest {

    PetEndpoint petEndpoint = new PetEndpoint();

    long createdPetId;

    @Before
    public void createPet() {
        Pet pet = new Pet("0", "SpikeJr", "available");
        ValidatableResponse response = petEndpoint.createPet(pet);
        createdPetId = response.extract().path("id");
    }

    @Test
    public void deletePet() {
        petEndpoint.deletePet(createdPetId);
    }
}
