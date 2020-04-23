import org.junit.Test;

public class GetPetByStatusTest {

    PetEndpoint petEndpoint = new PetEndpoint();

    @Test
    public void getByStatus() {
        petEndpoint.getPetByStatus(Status.SOLD);
    }
}