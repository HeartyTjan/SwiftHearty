package com.swiftHearty.services;

import com.swiftHearty.Exception.ItemAlreadyExistException;
import com.swiftHearty.data.models.Item;
import com.swiftHearty.data.repository.TrackingInfoRepository;
import com.swiftHearty.data.repository.TrackingInfos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemServiceTest {

    private ItemService itemService;
    private final TrackingInfoService trackingInfoService = new TrackingInfoServiceImpl();

    @BeforeEach
    public void setUp() {
        TrackingInfoRepository trackingInfoRepository = new TrackingInfos();
        trackingInfoService.setTrackingInfoRepository(trackingInfoRepository);
        itemService = new ItemServiceImpl(trackingInfoService);
    }

    @Test
    public void createAnewItem_ItemCountIncreaseByOneTest() {
        Item createdItem = itemService.createItem(new Item("New Item", 4000));
        assertEquals(4000,createdItem.getWeight());
    }

    @Test
    public void createNewItem_trackingInfoCreatedAndCountIncreaseByOneTest() {
        Item createdItem = itemService.createItem(new Item("new item", 4000));
        assertEquals(4000,createdItem.getWeight());
        assertEquals(1, trackingInfoService.NumberOfTrackingInfo());
     }
     @Test
     public void testThatItemAlreadyExistThrowException() {
        Item createdItem = itemService.createItem(new Item("New Item", 4000));
        assertEquals(4000,createdItem.getWeight());
        assertThrows(ItemAlreadyExistException.class, () -> itemService.createItem(new Item("New Item", 4000)));

     }
}