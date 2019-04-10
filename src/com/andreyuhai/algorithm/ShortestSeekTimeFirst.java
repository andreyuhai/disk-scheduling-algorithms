package com.andreyuhai.algorithm;

import com.andreyuhai.Request;
import com.andreyuhai.helper.Compare;

import java.util.PriorityQueue;

public class ShortestSeekTimeFirst {

    private int totalSeekTime;
    private int headLocation;
    private PriorityQueue<Request> queue;

    public ShortestSeekTimeFirst(int headLocation, PriorityQueue<Request> queue) {
        this.headLocation = headLocation;
        this.queue = queue;
    }

    public int calculateTotalSeekTime() {
        refreshSeekTimes();

        while(queue.size() != 0) {
            Request request = queue.poll();
            totalSeekTime += Math.abs(headLocation - request.trackLocation);
            System.out.println("Request : " + request.trackLocation);
            headLocation = request.trackLocation;

            refreshSeekTimes();
        }

        return totalSeekTime;
    }

    public void refreshSeekTimes() {
        PriorityQueue<Request> priorityQueue = new PriorityQueue<>(Compare.BySeekTime());

        while(queue.size() != 0) {
            Request request = queue.poll();
            request.seekTime = Math.abs(headLocation - request.trackLocation);
            priorityQueue.add(request);
        }

        this.queue = priorityQueue;
    }
}
