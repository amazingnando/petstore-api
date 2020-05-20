package model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreOrder {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private StoreOrderStatus status;
    private boolean complete;
}