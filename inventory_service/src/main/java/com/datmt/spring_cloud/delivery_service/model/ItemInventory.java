package com.datmt.spring_cloud.delivery_service.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ItemInventory {
    @Id
    private Long id;
    private String itemName;
    private Long quantity;
}
