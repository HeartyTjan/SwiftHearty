package com.swiftHearty.data.repository;

import com.swiftHearty.data.models.TrackingInfo;

import java.util.ArrayList;

public interface TrackingInfoRepository {
    int count();
    TrackingInfo save(TrackingInfo TrackingInfo);
    TrackingInfo findTrackingInfoById(int id);
    boolean existById(int id);
    void deleteById(int id);
    ArrayList<TrackingInfo> saveAll(TrackingInfo... TrackingInfos);
    void delete(TrackingInfo TrackingInfo);
    void deleteAllById(int ...ids);
   

}
