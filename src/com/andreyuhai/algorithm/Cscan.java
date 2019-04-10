package com.andreyuhai.algorithm;

import com.andreyuhai.Request;

import java.util.PriorityQueue;

public class Cscan {

    private int totalSeekTime;
    private int headLocation;
    private final int MAX;
    private PriorityQueue<Request> queue;
    private final int PREVIOUS_HEAD_LOCATION;

    public Cscan(int headLocation, PriorityQueue<Request> queue, final int MAX, final int PREVIOUS_HEAD_LOCATION) {
        this.headLocation = headLocation;
        this.queue = queue;
        this.MAX = MAX;
        this.PREVIOUS_HEAD_LOCATION = PREVIOUS_HEAD_LOCATION;
    }

    public int calculateTotalSeekTime() {

        return  0;
    }
}
