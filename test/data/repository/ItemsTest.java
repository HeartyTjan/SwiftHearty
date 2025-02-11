package data.repository;

import data.models.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ItemsTest {
    Items items;

    @BeforeEach
    void setUp() {
        items = new Items();
    }
    @AfterEach
    public void tearDown() {
        items = null;
    }
    @Test
    public void itemsIsEmptyTest() {
        Items items = new Items();
        assertEquals(0,items.count());
    }

    @Test
    public void addItemAndItemCountIncreaseByOneTest() {
        Items items = new Items();
        assertEquals(0,items.count());
        Item item = items.save(new Item());
        assertEquals(1,items.count());
    }

    @Test
    public void addItem_findItemByIdTest_Return_Item() {
        Items items = new Items();
        assertEquals(0,items.count());
        Item savedItem1 = items.save(new Item());
        assertEquals(1,items.count());
        Item savedItem2 = items.save(new Item());
        Item foundItem = items.findItemById(savedItem1.getId());
        assertEquals(savedItem1,foundItem);
    }

    @Test
    public void addItem_findItemById_UpdateItemTest() {
        Items items = new Items();
        assertEquals(0,items.count());
        Item savedItem = items.save(new Item("phone",50));
        assertEquals(1,items.count());

        int savedItemId = savedItem.getId();
        int saveItemWeight = savedItem.getWeight();

        Item foundItem = items.findItemById(savedItem.getId());
        foundItem.setWeightInGram(100);
        items.save(foundItem);
        assertEquals(1,items.count());

    }
    @Test
    public void addItem_checkIfItemAlreadyExistTest(){
        Items items = new Items();
        assertEquals(0,items.count());
        Item item = items.save(new Item());
        assertEquals(1,items.count());
        boolean isExisting = items.existById(item.getId());
        assertTrue(isExisting);
    }

    @Test
    public void addTwoItems_deleteOneItemById_itemSizeReduceByOneTest(){
        Items items = new Items();
        assertEquals(0,items.count());
        Item item = items.save(new Item());
        assertEquals(1,items.count());
        Item secondItem = items.save(new Item());
        assertEquals(2,items.count());
        items.deleteById(secondItem.getId());
        assertEquals(1,items.count());

    }

    @Test
    public void addThreeItems_saveAllItemsAtOnceAndReturnAllSaveItemsTest(){
        Items items = new Items();
        assertEquals(0,items.count());
        Item firstItem = new Item();
        Item secondItem = new Item();
        Item thirdItem = new Item();
        ArrayList<Item> returnedItems = items.saveAll(firstItem,secondItem,thirdItem);
        assertEquals(3,items.count());
        assertEquals(firstItem,returnedItems.getFirst());
        assertEquals(secondItem,returnedItems.get(1));
        assertEquals(thirdItem,returnedItems.get(2));

    }

    @Test
    public void addThreeItems_saveAllItems_thenDeleteAllItemsByIDTest(){
        Items items = new Items();
        assertEquals(0,items.count());
        Item firstItem = new Item("phone", 50);
        Item secondItem = new Item("book", 20);
        Item thirdItem = new Item("road", 30);
        items.saveAll(firstItem,secondItem,thirdItem);
        assertEquals(3,items.count());
        items.deleteAllById(firstItem.getId(),secondItem.getId(),thirdItem.getId());
        assertEquals(0,items.count());

    }
}