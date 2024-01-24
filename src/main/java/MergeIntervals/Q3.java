package MergeIntervals;
//Problem Challenge 1 - Minimum Meeting Rooms (hard)

import java.util.*;
public class Q3 {

    public static int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); //sort based on start time

        //use min heap to keep track of the end time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //add the first meeting's end time
        minHeap.offer(intervals[0][1]); //add the first end time to the heap

        for(int i = 1; i < intervals.length; i++) {
            System.out.println("i: "+i);
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            System.out.println("currStart: "+currStart);
            System.out.println("currEnd: "+currEnd);
            //check if the earliest ending meeting has ended before
            //current meeting starts

            if(currStart >= minHeap.peek()) {
                //currStart is the start time of the current meeting
                //peek() gets the earliest end time of ongoing meetings
                //which is the smallest value in the min heap
                System.out.println("currStart: "+currStart);
                System.out.println("minHeap.peek(): "+minHeap.peek());
                System.out.println("currEnd: "+currEnd);
                System.out.println("--------------");
                minHeap.poll();
            }

            //add the end time of the current meeting to the min heap
            minHeap.offer(currEnd);
            System.out.println("currEnd: "+currEnd);

        }

        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println("The minimum meeting rooms required: "+minMeetingRooms(intervals));
    }
}
