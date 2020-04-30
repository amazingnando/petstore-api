import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class GetPetByStatusTest {

    @Steps
    private PetEndpoint petEndpoint;

    @Test
    public void getByStatus() {
        petEndpoint.getPetByStatus(Status.SOLD);
    }
}