package com.example.BootcampProject;

import lombok.Data;

@Data
public class  Value {
   private Object mapVal;
    private  Integer intVal;

    public Object getMapVal() {
        return mapVal;
    }

    public void setMapVal(Object mapVal) {
        this.mapVal = mapVal;
    }

    public Integer getIntVal() {
        return intVal;
    }

    public void setIntVal(Integer intVal) {
        this.intVal = intVal;
    }
}
