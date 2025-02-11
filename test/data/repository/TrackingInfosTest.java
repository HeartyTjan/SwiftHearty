package data.repository;

import data.models.Item;
import data.models.TrackingInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackingInfosTest {
    @Test
    public void TrackingInfosIsEmptyTest() {
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
    }


    @Test
    public void addItemAndItemCountIncreaseByOneTest() {
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
        TrackingInfo trackingInfo = trackingInfos.save(new TrackingInfo());
        assertEquals(1,trackingInfos.count());
    }

    @Test
    public void addItem_findItemByIdTest_Return_Item() {
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
        TrackingInfo saveTrackingInfo = trackingInfos.save((new TrackingInfo()));
        assertEquals(1,trackingInfos.count());
        TrackingInfo saveTrackingInfo2 = trackingInfos.save((new TrackingInfo()));
        TrackingInfo foundTrackingInfo = trackingInfos.findTrackingInfoById(saveTrackingInfo.getId());
        assertEquals(saveTrackingInfo,foundTrackingInfo);
    }

    @Test
    public void addItem_findItemById_UpdateItemTest() {
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
        TrackingInfo saveTrackingInfo = trackingInfos.save((new TrackingInfo()));
        assertEquals(1,trackingInfos.count());
        TrackingInfo foundTrackingInfo= trackingInfos.findTrackingInfoById(saveTrackingInfo.getId());
        assertEquals(saveTrackingInfo,foundTrackingInfo);
        TrackingInfo updatedTrackingInfo = trackingInfos.save(saveTrackingInfo);

    }
    @Test
    public void addItem_checkIfItemAlreadyExistTest(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
        TrackingInfo trackingInfo = trackingInfos.save((new TrackingInfo()));
        assertEquals(1,trackingInfos.count());
        boolean isExisting = trackingInfos.existById(trackingInfo.getId());
        assertTrue(isExisting);
    }

    @Test
    public void addTwoItems_deleteOneItemById_itemSizeReduceByOneTest(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
        TrackingInfo trackingInfo = trackingInfos.save((new TrackingInfo()));
        assertEquals(1,trackingInfos.count());
        TrackingInfo secondTrackingInfo = trackingInfos.save((new TrackingInfo()));
        assertEquals(2,trackingInfos.count());
        trackingInfos.deleteById(secondTrackingInfo.getId());
        assertEquals(1,trackingInfos.count());

    }
}

