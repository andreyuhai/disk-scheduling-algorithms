package com.andreyuhai;

import com.andreyuhai.algorithm.FirstComeFirstServed;
import com.andreyuhai.algorithm.Scan;
import com.andreyuhai.algorithm.ShortestSeekTimeFirst;
import com.andreyuhai.helper.Compare;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here

        PriorityQueue<Request> requestQueue = new PriorityQueue<>(Compare.ByArrivalTime());
        PriorityQueue<Request> requestQueue2 = new PriorityQueue<>(Compare.ByArrivalTime());

        Request r1 = new RequestBuilder().trackLocation(95).arrivalTime(0).build();
        Request r2 = new RequestBuilder().trackLocation(180).arrivalTime(1).build();
        Request r3 = new RequestBuilder().trackLocation(34).arrivalTime(2).build();
        Request r4 = new RequestBuilder().trackLocation(119).arrivalTime(3).build();
        Request r5 = new RequestBuilder().trackLocation(11).arrivalTime(4).build();
        Request r6 = new RequestBuilder().trackLocation(123).arrivalTime(5).build();
        Request r7 = new RequestBuilder().trackLocation(62).arrivalTime(6).build();
        Request r8 = new RequestBuilder().trackLocation(64).arrivalTime(7).build();

        requestQueue.add(r8);
        requestQueue.add(r3);
        requestQueue.add(r2);
        requestQueue.add(r1);
        requestQueue.add(r5);
        requestQueue.add(r6);
        requestQueue.add(r4);
        requestQueue.add(r7);

        requestQueue2.add(r8);
        requestQueue2.add(r3);
        requestQueue2.add(r2);
        requestQueue2.add(r1);
        requestQueue2.add(r5);
        requestQueue2.add(r6);
        requestQueue2.add(r4);
        requestQueue2.add(r7);

        FirstComeFirstServed fcfs = new FirstComeFirstServed(50, requestQueue);
//        ShortestSeekTimeFirst sstf = new ShortestSeekTimeFirst(50, requestQueue2);
        Scan scan = new Scan(50, requestQueue2, 200,60, false);
        System.out.println("FCFS: " + fcfs.calculateTotalSeekTime());
        System.out.println("SSTF: " + scan.calculateTotalSeekTime());
    }
}
