package com.example.mvvmfirestoreandroidapp.model;

public class SampleModel {
    String sampleString;
    int sampleInt;
    Boolean sampleBoolean;

    public String getSampleString(){
        return sampleString;
    }

    public void setSampleString(String sampleString){
        this.sampleString = sampleString;
    }

    public int getSampleInt(){
        return sampleInt;
    }

    public void setSampleInt(int sampleInt) {
        this.sampleInt = sampleInt;
    }

    public Boolean getSampleBoolean(){
        return sampleBoolean;
    }

    public void setSampleBoolean(Boolean sampleBoolean) {
        this.sampleBoolean = sampleBoolean;
    }
}