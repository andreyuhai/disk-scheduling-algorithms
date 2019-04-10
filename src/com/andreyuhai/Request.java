package com.andreyuhai;

public class Request {

    public int deadLine;
    public int arrivalTime;
    public int seekTime;
    public int serviceTime; // For FD-Scan  http://oaji.net/articles/2014/661-1397393532.pdf
    public int trackLocation;


    public Request(){

    }

    public Request(int trackLocation, int arrivalTime, int seekTime, int deadLine, int serviceTime) {
        this.trackLocation = trackLocation;
        this.arrivalTime = arrivalTime;
        this.seekTime = seekTime;
        this.deadLine = deadLine;
        this.serviceTime = serviceTime;
    }
}
