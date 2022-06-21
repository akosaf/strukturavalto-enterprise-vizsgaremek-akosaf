package com.codecool.warehouseapp.service;

import com.codecool.warehouseapp.dao.ItemDao;
import com.codecool.warehouseapp.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    private final ItemDao itemDao;

    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public List<Item> findAll() {
        return itemDao.findAll();
    }

    public Item save(Item input) {
        Item item = new Item();
        return itemDao.save(item);
    }

    public void update(Item input, UUID id) {
        Item item = new Item();
        itemDao.save(item);
    }
}
