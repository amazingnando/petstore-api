import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;


@RunWith(SerenityParameterizedRunner.class)
public class UploadImageTest {


    @Steps
    private PetEndpoint petEndpoint;

    long createdPetId;
    private final String fileName;

    public UploadImageTest(String fileName) {
        this.fileName = fileName;
    }

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"png_19kb_150x150.png"},
                {"jpg_800kb_4000x2667.jpg"},
                {"png_3_mb_1920x1080.png"},
                {"doc_1MB.doc"},
                {"pdf_4kb.pdf"},
        });
    }

    @Before
    public void createPet() {
        Pet pet = new Pet("0", "SpikeJr", Status.AVAILABLE);
        ValidatableResponse response = petEndpoint.createPet(pet);
        createdPetId = response.extract().path("id");
    }

    @Test
    public void uploadImage() {
        petEndpoint.uploadImage(createdPetId, fileName);
    }


    @After
    public void deletePet() {
        petEndpoint.deletePet(createdPetId);
    }
}
