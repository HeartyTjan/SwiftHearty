package com.swiftHearty.data.repository;

import com.swiftHearty.data.models.Item;

import java.util.ArrayList;


public class Items implements ItemRepository{
    ArrayList<Item> items = new ArrayList<>();

    private int count = 0;
    
    public int count() {
        return items.size();
    }

    public Item save(Item item) {
        if(isNew(item)) saveNew(item);
        else replace(item);
        return item;
    }

    private void saveNew(Item item) {
        item.setId(generateId());
        items.add(item);
    }

    private boolean isNew(Item item) {
        return item.getId() == 0L;
    }

    private void replace(Item item) {
        deleteById(item.getId());
        items.add(item);
    }

    public Item findItemById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;

    }

    public boolean existById(int id) {
       for (Item item : items) {
            if(item.getId() == id) return true;
           }
        return false;
    }

    public boolean existByDescription(String description) {
       for (Item item : items) {
            if(item.getDescription().equalsIgnoreCase(description)) return true;
           }
        return false;
    }

    public void deleteById(int id) {
        items.removeIf(item -> item.getId() == id);
    }
    public int generateId(){
        count++;
       return count;
    }

    public ArrayList<Item> saveAll(Item ...items) {
        ArrayList<Item> itemsToReturn = new ArrayList<>();
        for (Item newItem : items) {
            save(newItem);
            itemsToReturn.add(newItem);
        }

        return itemsToReturn;
    }

    public void deleteAllById(int ...ids) {
        for(int id : ids){
            deleteById(id);
        }
    }

    public void deleteAll(Item...items) {

        for(Item item : items){
            delete(item);
        }
    }

    public void delete(Item item) {
        deleteById(item.getId());
    }
}
