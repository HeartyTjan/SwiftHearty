package com.swiftHearty.data.repository;

import com.swiftHearty.data.models.Item;

import java.util.ArrayList;


public interface ItemRepository {
    int count();
    Item save(Item item);
    Item findItemById(int id);
    boolean existById(int id);
    boolean existByDescription(String description);
    void deleteById(int id);
    ArrayList<Item> saveAll(Item... items);
    void delete(Item item);
    void deleteAllById(int ...ids);
}
