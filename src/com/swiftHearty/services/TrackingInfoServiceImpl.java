package com.swiftHearty.services;

import com.swiftHearty.data.models.TrackingInfo;
import com.swiftHearty.data.repository.TrackingInfoRepository;
import com.swiftHearty.data.repository.TrackingInfos;

public class TrackingInfoServiceImpl implements TrackingInfoService{
    private TrackingInfoRepository trackingInfoRepository;
    public void setTrackingInfoRepository(TrackingInfoRepository trackingInfoRepository) {
        this.trackingInfoRepository = trackingInfoRepository;
    }

    public void createTrackingInfo(int itemId) {
        TrackingInfo trackingInfo = new TrackingInfo();
        trackingInfo.setItemId(itemId);
        trackingInfo.setInfo("Item currently at warehouse");
        trackingInfoRepository.save(trackingInfo);
    }

    @Override
    public int NumberOfTrackingInfo() {
        return trackingInfoRepository.count();
    }
}
