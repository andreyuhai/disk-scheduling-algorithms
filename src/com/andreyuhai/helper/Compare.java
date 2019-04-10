package com.andreyuhai.helper;

import com.andreyuhai.Request;

import java.util.Comparator;

public abstract class Compare implements Comparator<Request> {

    public Compare() {

    }

    public static Compare BySeekTime() {
        return new BySeekTime();
    }

    public static Compare ByArrivalTime() {
        return new ByArrivalTime();
    }

    public static Compare ByTrackLocation() {
        return new ByTrackLocation();
    }

    public static Compare ByInverseTrackLocation() {
        return new ByInverseTrackLocation();
    }

    static class BySeekTime extends Compare{

        @Override
        public int compare(Request r1, Request r2) {
            return r1.seekTime - r2.seekTime;
        }
    }

    static class ByArrivalTime extends Compare{
        @Override
        public int compare(Request r1, Request r2) {
            return r1.arrivalTime - r2.arrivalTime;
        }
    }

    static class ByInverseTrackLocation extends Compare{
        @Override
        public int compare(Request r1, Request r2) {
            return r2.trackLocation - r1.trackLocation;
        }
    }

    static class ByTrackLocation extends Compare{
        @Override
        public int compare(Request r1, Request r2) {
            return r1.trackLocation - r2.trackLocation;
        }
    }

}
