package com.datmt.spring_cloud.delivery_service.controller;

import com.datmt.spring_cloud.delivery_service.model.ItemInventory;
import com.datmt.spring_cloud.delivery_service.model.ItemTransaction;
import com.datmt.spring_cloud.delivery_service.repository.ItemInventoryRepository;
import com.datmt.spring_cloud.delivery_service.repository.ItemTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class InventoryController {
    private final ItemInventoryRepository itemInventoryRepository;
    private final ItemTransactionRepository itemTransactionRepository;

    @PostMapping
    public ItemInventory create(@RequestBody ItemInventory itemInventory) {

        var existingItemInventory = itemInventoryRepository.findByItemName(itemInventory.getItemName());

        if (existingItemInventory.isPresent()) {
            throw new IllegalArgumentException("Item already exists");
        }

        return itemInventoryRepository.save(itemInventory);
    }

    @GetMapping("/{itemName}")
    public ItemInventory get(@PathVariable String itemName) {
        return itemInventoryRepository.findByItemName(itemName).orElseThrow();
    }

    @PostMapping("/update")
    public ItemInventory updateStock(@RequestBody ItemTransaction itemTransaction) {
        var netItem = itemTransaction.isGoingIn() ? itemTransaction.getQuantity() : -itemTransaction.getQuantity();

        synchronized (itemInventoryRepository) {
            var itemInventory = itemInventoryRepository.findByItemName(itemTransaction.getItemName()).orElseThrow();
            itemInventory.setQuantity(itemInventory.getQuantity() + netItem);
            itemTransactionRepository.save(itemTransaction);
            return itemInventoryRepository.save(itemInventory);
        }
    }
}
