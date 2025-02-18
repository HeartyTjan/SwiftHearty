package com.swiftHearty.services;

import com.swiftHearty.data.repository.TrackingInfoRepository;

public interface TrackingInfoService {
     int NumberOfTrackingInfo();
     void createTrackingInfo(int itemId);

     void setTrackingInfoRepository(TrackingInfoRepository trackingInfoRepository);
}
