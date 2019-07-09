package com.example.BootcampProject;

import lombok.Data;

@Data
public class GoogleFitStepResponse {
    BucketElement[] bucket;
  // public GoogleFitStepResponse(){}

    /*private String startTimeMillis;
    private String endTImeMillis;
    private  int intVal;*/

    public BucketElement[] getBucket() {
        return bucket;
    }

    public void setBucket(BucketElement[] bucket) {
        this.bucket = bucket;
    }
}
