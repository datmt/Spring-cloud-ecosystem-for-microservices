package com.datmt.spring_cloud.shopping_service.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Data
@Entity
public class OrderItem {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private  String itemName;
    private Long itemPrice;
    private Long quantity;

}
