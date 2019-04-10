package com.andreyuhai.algorithm;

import com.andreyuhai.Request;

import java.util.PriorityQueue;

public class FirstComeFirstServed {

    private int totalSeekTime;
    private int headLocation;
    private PriorityQueue<Request> queue;

    public FirstComeFirstServed(int headLocation, PriorityQueue<Request> queue) {
        this.queue = queue;
        this.headLocation = headLocation;
    }

    public int calculateTotalSeekTime() {
        while(queue.size() != 0) {
            Request request = queue.poll();
            totalSeekTime += Math.abs(headLocation - request.trackLocation);
            headLocation = request.trackLocation;
        }

        return totalSeekTime;
    }
}
