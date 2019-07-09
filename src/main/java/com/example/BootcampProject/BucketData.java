package com.example.BootcampProject;

import lombok.Data;

@Data
public class BucketData {
   private String dataSourceId;
   private PointData[] point;

   public String getDataSourceId() {
      return dataSourceId;
   }

   public void setDataSourceId(String dataSourceId) {
      this.dataSourceId = dataSourceId;
   }

   public PointData[] getPoint() {
      return point;
   }

   public void setPoint(PointData[] point) {
      this.point = point;
   }
}
