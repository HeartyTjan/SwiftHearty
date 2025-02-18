package com.swiftHearty.data.repository;

import com.swiftHearty.data.models.TrackingInfo;


import java.util.ArrayList;

public class TrackingInfos implements TrackingInfoRepository{
    ArrayList<TrackingInfo> trackingInfos = new ArrayList<>();

    int count = 0;

    public int count() {
        return trackingInfos.size();
    }

    public void setCount(int count) {
    }

    public TrackingInfo save(TrackingInfo trackingInfo) {
        if(isNew(trackingInfo))saveNew(trackingInfo);
        else replace(trackingInfo);
        return trackingInfo;
    }

    private void saveNew(TrackingInfo trackingInfo) {
        trackingInfo.setId(generateId());
        trackingInfos.add(trackingInfo);
    }

    private void replace(TrackingInfo trackingInfo) {
        deleteById(trackingInfo.getId());
        trackingInfos.add(trackingInfo);
    }


    private boolean isNew(TrackingInfo trackingInfo) {
        return trackingInfo.getId() == 0;
    }

    public TrackingInfo findTrackingInfoById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos) {
            if (trackingInfo.getId() == id) {
                return trackingInfo;
            }
        }
        return null;

    }

    public boolean existById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos) {
            if(trackingInfo.getId() == id) return true;
        }
        return false;
    }

    public void deleteById(int id) {
        trackingInfos.removeIf(trackingInfo -> trackingInfo.getId() == id);
    }
    public int generateId(){
        count++;
        return count;
    }

    public void delete(TrackingInfo trackingInfo) {
        deleteById(trackingInfo.getId());
    }



    public ArrayList<TrackingInfo> saveAll(TrackingInfo... trackingInfos) {
        ArrayList<TrackingInfo> trackingInfosToReturn = new ArrayList<>();
        for (TrackingInfo newTrackingInfo : trackingInfos) {
            save(newTrackingInfo);
            trackingInfosToReturn.add(newTrackingInfo);
        }
        return trackingInfosToReturn;
    }

    public void deleteAllById(int ...ids) {
        for(int id : ids){
            deleteById(id);
        }
    }
}
