package com.example.BootcampProject;

import lombok.Data;

@Data
public class BucketElement {
    private String startTimeMillis;
    private String endTimeMillis;
    private BucketData[] dataset;

    public String getStartTimeMillis() {
        return startTimeMillis;
    }

    public void setStartTimeMillis(String startTimeMillis) {
        this.startTimeMillis = startTimeMillis;
    }

    public String getEndTimeMillis() {
        return endTimeMillis;
    }

    public void setEndTimeMillis(String endTimeMillis) {
        this.endTimeMillis = endTimeMillis;
    }

    public BucketData[] getDataset() {
        return dataset;
    }

    public void setDataset(BucketData[] dataset) {
        this.dataset = dataset;
    }
}
