package com.datmt.spring_cloud.shopping_service.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Order {

    @Id
    private Long id;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
