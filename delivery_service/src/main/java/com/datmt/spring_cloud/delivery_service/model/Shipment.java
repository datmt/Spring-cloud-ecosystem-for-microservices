package com.datmt.spring_cloud.delivery_service.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Shipment {
    @Id
    private Long id;
    private String customerEmail;
    private String orderUUID;
    private String description;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime createdAt;
    private LocalDateTime expectedDeliveryDate;
}


