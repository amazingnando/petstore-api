import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

public class UploadImageTest {

    PetEndpoint petEndpoint = new PetEndpoint();

    long createdPetId;

    @Before
    public void createPet() {
        Pet pet = new Pet("0", "SpikeJr", Status.AVAILABLE);
        ValidatableResponse response = petEndpoint.createPet(pet);
        createdPetId = response.extract().path("id");
    }

    @Test
    public void uploadSmallImage() {
        petEndpoint.uploadImage(createdPetId, "png_19kb_150x150.png");
    }

    @Test
    public void uploadImageJpg() {
        petEndpoint.uploadImage(createdPetId, "jpg_800kb_4000x2667.jpg");
    }

    @Test
    public void uploadImagePng() {
        petEndpoint.uploadImage(createdPetId, "png_3_mb_1920x1080.png");
    }

    @Test
    public void uploadDoc() {
        petEndpoint.uploadImage(createdPetId, "doc_1MB.doc");
    }

    @Test
    public void uploadPdf() {
        petEndpoint.uploadImage(createdPetId, "pdf_4kb.pdf");
    }


    @After
    public void deletePet() {
        petEndpoint.deletePet(createdPetId);
    }
}
