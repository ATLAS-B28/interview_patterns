package MergeIntervals;

//Merge and insert intervals
/*
* Merge Intervals: In this problem, you are given a collection
* of intervals, where each interval is represented as a pair of
* integers [start, end]. The goal is to merge overlapping
* intervals and return a new collection of non-overlapping intervals.
* */
/*
* Insert Interval: In this problem, you are given a collection of
* non-overlapping intervals and a new interval to insert. The goal
* is to insert the new interval into the collection while maintaining
* the non-overlapping property. If the new interval overlaps with existing
* intervals, it should be merged accordingly.
* */

import java.util.*;
public class BaseExample {

    public static int[][] mergeIntervals(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //sorts the array based on start value of each interval

        List<int[]> merged = new ArrayList<>();
        int[] currInterval = intervals[0];
        merged.add(currInterval);

        for(int[] interval : intervals) {
            int currEnd = currInterval[1];//end value of current interval
            int nextStart = interval[0];//start value of next interval
            int nextEnd = interval[1];//end value of next interval

            if(currEnd >= nextStart) {//if true that means they overlap
                currInterval[1] = Math.max(currEnd, nextEnd);//the current end value
                //is updated to the max of the two
            } else { //currEnd < nextStart
                currInterval = interval;//then current is updated to next interval
                merged.add(currInterval);//as no overlapping happens we add the next interval
            }
        }

        return merged.toArray(new int[merged.size()][]);//2D array
    }

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0]) {
            //intervals[i][1] is the end value of the current interval
            //and newInterval[0] start value of the new interval
            //if current end value is less than new interval start value
            //then it is not overlapping
            merged.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]) {
            //intervals[i][0] is the start value of the current interval
            //and newInterval[1] end value of the new interval
            //if current start value is less than or equal to new interval end value
            //then it is overlapping
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            //update the new interval in the new interval's start value
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            //update the new interval in the new interval's end value
            i++;
        }

        merged.add(newInterval);//add the new interval

        while(i < n) {
            merged.add(intervals[i]);
            i++;
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {12, 16}, {15, 18}};
        int[][] mergedIntervals = mergeIntervals(intervals);
        System.out.println("Merged Intervals: " + Arrays.deepToString(mergedIntervals));

        int[][] intervals2 = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] mergedIntervals2 = insertInterval(intervals2, newInterval);
        System.out.println("Inserted Interval: " + Arrays.deepToString(mergedIntervals2));



    }
}
