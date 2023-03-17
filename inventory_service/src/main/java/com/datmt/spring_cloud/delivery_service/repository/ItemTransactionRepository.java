package com.datmt.spring_cloud.delivery_service.repository;

import com.datmt.spring_cloud.delivery_service.model.ItemInventory;
import com.datmt.spring_cloud.delivery_service.model.ItemTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemTransactionRepository extends JpaRepository<ItemTransaction, Long> {
    Optional<ItemTransaction> findByItemName(String itemName);
}
