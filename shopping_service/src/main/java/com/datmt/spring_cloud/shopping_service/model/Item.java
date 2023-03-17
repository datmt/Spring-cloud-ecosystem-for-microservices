package com.datmt.spring_cloud.shopping_service.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Item {
    @Id
    private Long id;
    private String itemName;
    private Long itemPrice;
}
