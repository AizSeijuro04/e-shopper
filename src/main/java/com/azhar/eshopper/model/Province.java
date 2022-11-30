package com.azhar.eshopper.model;

public class Province {
    private long provId;
    private String provName;
    
    //default atau empty contructor
    public Province() {
    }

    //parameter constructor
    public Province(long provId, String provName) {
        this.provId = provId;
        this.provName = provName;
    }


    //getter and setter
    public long getProvId() {
        return provId;
    }

    public void setProvId(long provId) {
        this.provId = provId;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }
    
}
