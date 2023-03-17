package com.datmt.spring_cloud.delivery_service.repository;

import com.datmt.spring_cloud.delivery_service.model.ItemInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemInventoryRepository extends JpaRepository<ItemInventory, Long> {
    Optional<ItemInventory> findByItemName(String itemName);
}
