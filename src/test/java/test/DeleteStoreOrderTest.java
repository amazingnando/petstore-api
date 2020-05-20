package test;

import endPoint.PetEndpoint;
import io.restassured.response.ValidatableResponse;
import model.StoreOrder;
import model.StoreOrderStatus;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ThreadLocalRandom;

@RunWith(SerenityRunner.class)
public class DeleteStoreOrderTest {

    @Steps
    private PetEndpoint petEndpoint;
    private int StoreOrderId;

    public DeleteStoreOrderTest() {
    }

    @Before
    public void createStoreOrder() {
        StoreOrder order = StoreOrder.builder()
                .id(ThreadLocalRandom.current().nextInt(1, 1000 + 1))
                .petId(1)
                .quantity(1)
                .shipDate(String.valueOf(System.currentTimeMillis()))
                .status(StoreOrderStatus.PLACED)
                .complete(true)
                .build();
        ValidatableResponse response = petEndpoint.createStoreOrder(order);
        StoreOrderId = response.extract().path("id");

    }

    @Test
    public void deleteStoreOrder() {
        petEndpoint.deleteStoreOrder(StoreOrderId);
    }
}