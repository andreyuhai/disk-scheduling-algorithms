package com.andreyuhai.algorithm;

import com.andreyuhai.Request;
import com.andreyuhai.helper.Compare;

import java.util.PriorityQueue;

public class Scan {

    private int totalSeekTime;
    private int headLocation;
    private final int MAX;
    private PriorityQueue<Request> queue;
    private final int PREVIOUS_HEAD_LOCATION;
    private boolean isCscan;

    public Scan(int headLocation, PriorityQueue<Request> queue, final int MAX, final int PREVIOUS_HEAD_LOCATION, boolean isCscan) {
        this.headLocation = headLocation;
        this.queue = queue;
        this.MAX = MAX;
        this.PREVIOUS_HEAD_LOCATION = PREVIOUS_HEAD_LOCATION;
        this.isCscan = isCscan;
    }

    public int calculateTotalSeekTime() {
        PriorityQueue<Request> rightPart;
        PriorityQueue<Request> leftPart = new PriorityQueue<>(Compare.ByInverseTrackLocation());

        // Which means going up
        if(PREVIOUS_HEAD_LOCATION < headLocation) {
            rightPart = new PriorityQueue<>(Compare.ByTrackLocation());
        } else {
            rightPart = new PriorityQueue<>(Compare.ByInverseTrackLocation());
        }

        while(queue.size() != 0) {
            Request request = queue.poll();
            if(request.trackLocation > headLocation)
                rightPart.add(request);
            else
                leftPart.add(request);
        }

        // Which means the head is close to the end.
        if(headLocation > PREVIOUS_HEAD_LOCATION) {
            while(rightPart.size() != 0) {
                Request request = rightPart.poll();
                System.out.println("Track: " + request.trackLocation);

                totalSeekTime += Math.abs(headLocation - request.trackLocation);
                headLocation = request.trackLocation;
            }

            totalSeekTime += MAX - headLocation - 1;
            headLocation = MAX - 1;

            while(leftPart.size() != 0) {
                Request request = leftPart.poll();
                System.out.println("Track--: " + request.trackLocation);

                totalSeekTime += Math.abs(headLocation - request.trackLocation);
                headLocation = request.trackLocation;
            }
        } else {

            while(leftPart.size() != 0) {
                Request request = leftPart.poll();
                System.out.println("Track: " + request.trackLocation);
                totalSeekTime += Math.abs(headLocation - request.trackLocation);
                headLocation = request.trackLocation;
            }

            totalSeekTime += headLocation;

            if(isCscan)
                headLocation = MAX - 1;
            else
                headLocation = rightPart.peek().trackLocation;

            while(rightPart.size() != 0) {
                Request request = rightPart.poll();

                System.out.println("Track: " + request.trackLocation);

                totalSeekTime += Math.abs(headLocation - request.trackLocation);
                headLocation = request.trackLocation;
            }

            if(!isCscan)
                totalSeekTime += headLocation;

        }
        return totalSeekTime;
    }

}
