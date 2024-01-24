package MergeIntervals;

import java.util.*;

//Conflicting Appointments
public class Q2 {

    public static boolean hasConflictingAppointments(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currInterval = intervals[0];
        merged.add(currInterval);

        for(int i = 1; i < intervals.length; i++) {
            int currEnd = currInterval[1];
            int nextStart = intervals[i][0];

            if(currEnd >= nextStart) {
                return true;
            } else {
                currInterval = intervals[i];
                merged.add(currInterval);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 5}, {7, 9}};
        System.out.println("The appointments are conflicting? "+hasConflictingAppointments(intervals));
    }
}
