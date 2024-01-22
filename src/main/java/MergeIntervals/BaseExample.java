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

        List<int[]> merged = new ArrayList<>();
        int[] currInterval = intervals[0];
        merged.add(currInterval);

        for(int[] interval : intervals) {
            int currEnd = currInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if(currEnd >= nextStart) {
                currInterval[1] = Math.max(currEnd, nextEnd);
            } else { //currEnd < nextStart
                currInterval = interval;
                merged.add(currInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        merged.add(newInterval);

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
