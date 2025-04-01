package com.java.core.beans;

public class HospitalInfra {
     private int opdNo;
   private  String opdName;

    public String getOpdName() { return opdName;}
    public void setOpdName(String opdName) { this.opdName = opdName;}

    public int getOpdNo() { return opdNo;}
    public void setOpdNo(int opdNo) { this.opdNo = opdNo;}

    public HospitalInfra(int opdNo, String opdName) {
        this.opdNo = opdNo;
        this.opdName = opdName;
    }

    @Override
    public String toString() {
        return "HospitalInfra{" + "opdName='" + opdName + '\'' + ", opdNo=" + opdNo + '}';
    }
}
