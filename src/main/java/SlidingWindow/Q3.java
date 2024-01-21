package SlidingWindow;

//Smallest Subarray with a given sum

public class Q3 {

    public static int FindMinSubArray(int targetSum, int[] arr) {
        int minLen = Integer.MAX_VALUE;
        int windowSum = 0;
        int start = 0;

        for(int end = 0; end < arr.length; end++) {
            windowSum += arr[end];
            System.out.println("( "+end+" )");
            System.out.println("end: "+end);
            System.out.println("arr[end]: "+arr[end]);
            System.out.println("windowSum: "+windowSum);
            System.out.println("--------");

            while(windowSum >= targetSum) {
                minLen = Math.min(minLen, end - start + 1);
                System.out.println("minLen: "+minLen);
                windowSum -= arr[start];
                System.out.println("windowSum: "+windowSum);
                start++;
                System.out.println("start: "+start);
                System.out.println("arr[start]: "+arr[start]);
                System.out.println("--------");
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

    public static void main(String[] args) {
        int targetSum = 7;
        int[] arr = {2, 1, 5, 2, 3, 2};
        System.out.println("Length of the smallest subarray: "+FindMinSubArray(targetSum, arr));
    }
}