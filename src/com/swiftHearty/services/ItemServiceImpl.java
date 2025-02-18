package com.swiftHearty.services;

import com.swiftHearty.Exception.ItemAlreadyExistException;
import com.swiftHearty.data.models.Item;
import com.swiftHearty.data.models.TrackingInfo;
import com.swiftHearty.data.repository.ItemRepository;
import com.swiftHearty.data.repository.Items;
import com.swiftHearty.data.repository.TrackingInfoRepository;


public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository = new Items();

    private final TrackingInfoService trackingInfoService;

    public ItemServiceImpl(TrackingInfoService trackingInfoService) {
        this.trackingInfoService = trackingInfoService;
    }


    @Override
    public Item createItem(Item newItem) {
        if(itemRepository.existByDescription(newItem.getDescription())) {
            throw new ItemAlreadyExistException("Item with id " + newItem.getId() + " already exists");
        }
        Item savedItem = itemRepository.save(newItem);
        trackingInfoService.createTrackingInfo(savedItem.getId());
        return newItem;

    }
}
