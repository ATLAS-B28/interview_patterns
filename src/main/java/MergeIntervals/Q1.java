package MergeIntervals;

import java.util.Arrays;

//Intervals Intersection
public class Q1 {

    public static int[] findIntervalIntersection(int[] interval1, int[] interval2) {
        int start = Math.max(interval1[0], interval2[0]);
        //max of both start values
        int end = Math.min(interval1[1], interval2[1]);
        //min of both end values
        if(start <= end) {
            return new int[]{start, end};
        } else {
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        int[] interval1 = {1, 3};
        int[] interval2 = {2, 4};

        int[] result = findIntervalIntersection(interval1, interval2);
        System.out.println("Result: " + Arrays.toString(result));
    }
}
