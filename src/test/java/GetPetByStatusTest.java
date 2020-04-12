import org.junit.Test;

public class GetPetByStatusTest {

    PetEndpoint petEndpoint = new PetEndpoint();
    String status="sold";

    @Test
    public void getByStatus() {
        petEndpoint.getPetByStatus(status);
    }
}