package com.datmt.spring_cloud.delivery_service.repository;

import com.datmt.spring_cloud.delivery_service.model.DeliveryStatus;
import com.datmt.spring_cloud.delivery_service.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShipmentRepository  extends JpaRepository<Shipment, Long> {
    Optional<List<Shipment>> findAllByCustomerEmail(String customerEmail);
    Optional<List<Shipment>> findAllByCustomerEmailAndDeliveryStatus(String customerEmail, DeliveryStatus status);

}
