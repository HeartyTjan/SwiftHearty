package data.repository;

import data.models.Item;

import java.util.ArrayList;
import java.util.InputMismatchException;


public class Items {
    ArrayList<Item> items = new ArrayList<>();
    int count = 0;
    public int count() {
        return items.size();
    }

    public void setCount(int count) {
    }

    public Item save(Item item) {
        if(isNew(item)) {
            item.setId(generateId());
            items.add(item);
            return item;
        }
        Item existingItem = findItemById(item.getId());
        existingItem.setWeightInGram(item.getWeight());
        existingItem.setDescription(item.getDescription());
        return existingItem;
    }

    private boolean isNew(Item item) {
        return findItemById(item.getId()) == null;
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

    public void deleteById(int id) {
        items.removeIf(item -> item.getId() == id);
    }
    public int generateId(){
       return count++;
    }

    public ArrayList<Item> saveAll(Item ...item) {
        ArrayList<Item> itemsToReturn = new ArrayList<>();
        for (Item newItem : item) {
            save(newItem);
            itemsToReturn.add(newItem);
        }


        return itemsToReturn;
    }

    public void deleteAllById(int...ids) {
        for(int id : ids){
            deleteById(id);
        }
    }
}
