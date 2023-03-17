package com.datmt.spring_cloud.delivery_service.controller;

import com.datmt.spring_cloud.delivery_service.model.DeliveryStatus;
import com.datmt.spring_cloud.delivery_service.model.Shipment;
import com.datmt.spring_cloud.delivery_service.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class DeliveryController {

    private final ShipmentRepository shipmentRepository;

    @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        if (shipment.getId() != null) {
            throw new IllegalArgumentException("Shipment ID must be null");
        }
        return shipmentRepository.save(shipment);
    }

    @PostMapping
    public Shipment updateShipment(@RequestBody Shipment shipment) {
        var existingShipment = shipmentRepository.findById(shipment.getId()).orElseThrow();
        existingShipment.setDeliveryStatus(shipment.getDeliveryStatus());

        return shipmentRepository.save(existingShipment);
    }

    @GetMapping("/all-by-customer-email/{customerEmail}")
    public List<Shipment> getAllShipmentsByCustomerEmail(@PathVariable String customerEmail) {
        return shipmentRepository.findAllByCustomerEmail(customerEmail).orElse(List.of());
    }

    @GetMapping("/all-by-customer-email/{customerEmail}/{deliveryStatus}")
    public List<Shipment> getAllShipmentsByCustomerEmailAndDeliveryStatus(@PathVariable String customerEmail, @PathVariable DeliveryStatus deliveryStatus) {
        return shipmentRepository.findAllByCustomerEmailAndDeliveryStatus(customerEmail, deliveryStatus).orElse(List.of());
    }

}
