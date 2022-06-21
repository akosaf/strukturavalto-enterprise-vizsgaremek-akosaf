package com.codecool.warehouseapp.controller;

import com.codecool.warehouseapp.model.Item;
import com.codecool.warehouseapp.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @PostMapping
    public Item save(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Item item, @PathVariable("id") UUID id) {
        itemService.update(item, id);
    }
}
