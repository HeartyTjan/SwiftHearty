package data.models;

import java.time.LocalDateTime;

public class TrackingInfo {
    private String itemId;
    private int id;
    private String info;
    private LocalDateTime dateTime = LocalDateTime.now();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
