package com.andreyuhai;

public class RequestBuilder {

    public int deadLine;
    public int arrivalTime;
    public int serviceTime;
    public int trackLocation;

    public RequestBuilder deadLine(int deadLine) {
        this.deadLine = deadLine;
        return this;
    }

    public RequestBuilder arrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public RequestBuilder trackLocation(int trackLocation) {
        this.trackLocation = trackLocation;
        return this;
    }

    public Request build() {
        Request request = new Request();
        request.arrivalTime = arrivalTime;
        request.deadLine = deadLine;
        request.trackLocation = trackLocation;

        return request;
    }
}
