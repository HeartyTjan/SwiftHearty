package data.repository;

import data.models.TrackingInfo;
import data.models.TrackingInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TrackingInfosTest {
    TrackingInfos trackingInfos;

    @BeforeEach
    void setUp() {
        trackingInfos = new TrackingInfos();
    }

    @AfterEach
    public void tearDown() {
        trackingInfos = null;
    }

    @Test
    public void TrackingInfosIsEmptyTest() {
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
    }


    @Test
    public void addTrackingInfoAndCountIncreaseByOneTest() {
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
        TrackingInfo trackingInfo = trackingInfos.save(new TrackingInfo());
        assertEquals(1,trackingInfos.count());
    }

    @Test
    public void addTrackingInfo_findTrackingInfoByIdTest_Return_TrackingInfo() {
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
        TrackingInfo saveTrackingInfo = trackingInfos.save((new TrackingInfo()));
        assertEquals(1,trackingInfos.count());
        TrackingInfo saveTrackingInfo2 = trackingInfos.save((new TrackingInfo()));
        TrackingInfo foundTrackingInfo = trackingInfos.findTrackingInfoById(saveTrackingInfo.getId());
        assertEquals(saveTrackingInfo,foundTrackingInfo);
    }

    @Test
    public void addTrackingInfo_findTrackingInfoById_UpdateTrackingInfoTest() {
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
        TrackingInfo saveTrackingInfo = trackingInfos.save((new TrackingInfo()));
        assertEquals(1,trackingInfos.count());
        TrackingInfo foundTrackingInfo= trackingInfos.findTrackingInfoById(saveTrackingInfo.getId());
        foundTrackingInfo.setInfo("It is edited");
        trackingInfos.save(foundTrackingInfo);
        assertEquals(1,trackingInfos.count());

    }
    @Test
    public void addTrackingInfo_checkIfTrackingInfoAlreadyExistTest(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
        TrackingInfo trackingInfo = trackingInfos.save((new TrackingInfo()));
        assertEquals(1,trackingInfos.count());
        boolean isExisting = trackingInfos.existById(trackingInfo.getId());
        assertTrue(isExisting);
    }

    @Test
    public void addTwoTrackingInfos_deleteOneTrackingInfoById_TrackingInfoSizeReduceByOneTest(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0,trackingInfos.count());
        TrackingInfo trackingInfo = trackingInfos.save((new TrackingInfo()));
        assertEquals(1,trackingInfos.count());
        TrackingInfo secondTrackingInfo = trackingInfos.save((new TrackingInfo()));
        assertEquals(2,trackingInfos.count());
        trackingInfos.deleteById(secondTrackingInfo.getId());
        assertEquals(1,trackingInfos.count());

    }

    @Test
    public void addThreeTrackingInfo_saveAllTrackingInfoAtOnceAndReturnAllSaveTrackingInfoTest(){
        TrackingInfos TrackingInfos = new TrackingInfos();
        assertEquals(0,TrackingInfos.count());
        TrackingInfo firstTrackingInfo = new TrackingInfo();
        TrackingInfo secondTrackingInfo = new TrackingInfo();
        TrackingInfo thirdTrackingInfo = new TrackingInfo();
        ArrayList<TrackingInfo> returnedTrackingInfos = TrackingInfos.saveAll(firstTrackingInfo,secondTrackingInfo,thirdTrackingInfo);
        assertEquals(3,TrackingInfos.count());
        assertEquals(firstTrackingInfo,returnedTrackingInfos.getFirst());
        assertEquals(secondTrackingInfo,returnedTrackingInfos.get(1));
        assertEquals(thirdTrackingInfo,returnedTrackingInfos.get(2));

    }

    @Test
    public void addThreeTrackingInfos_saveAllTrackingInfos_thenDeleteAllTrackingInfoByIDTest(){
        TrackingInfos TrackingInfos = new TrackingInfos();
        assertEquals(0,TrackingInfos.count());
        TrackingInfo firstTrackingInfo = new TrackingInfo();
        TrackingInfo secondTrackingInfo = new TrackingInfo();
        TrackingInfo thirdTrackingInfo = new TrackingInfo();
        TrackingInfos.saveAll(firstTrackingInfo,secondTrackingInfo,thirdTrackingInfo);
        assertEquals(3,TrackingInfos.count());
        TrackingInfos.deleteAllById(firstTrackingInfo.getId(),secondTrackingInfo.getId(),thirdTrackingInfo.getId());
        assertEquals(0,TrackingInfos.count());

    }

    @Test
    public void addThreeTrackingInfo_saveAllTrackingInfo_deleteTwoTrackingInfoTest(){
        assertEquals(0,trackingInfos.count());
        TrackingInfo firstTrackingInfo = new TrackingInfo();
        TrackingInfo secondTrackingInfo = new TrackingInfo();
        TrackingInfo thirdTrackingInfo = new TrackingInfo();
        trackingInfos.saveAll(firstTrackingInfo,secondTrackingInfo,thirdTrackingInfo);
        assertEquals(3,trackingInfos.count());
        trackingInfos.delete(firstTrackingInfo);
        trackingInfos.delete(secondTrackingInfo);
        assertEquals(1,trackingInfos.count());
    }

}

