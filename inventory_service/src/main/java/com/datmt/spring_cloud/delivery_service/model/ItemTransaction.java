package com.datmt.spring_cloud.delivery_service.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

//Represents item in and out of inventory
@Data
public class ItemTransaction {
    @Id
    private Long id;
    private String itemName;
    private Long quantity;
    @CreatedDate
    private LocalDateTime createdAt;
    private boolean goingIn; //true if going in, false if going out
}