package SlidingWindow;

/*
* Maximum Sum Subarray
* of Size K (easy)
* */
public class Q1 {
    //k is size of sub-array
    public static int findMaxSumSubarray(int[] nums,int k) {
        int maxSum = 0;//existing max sum
        int windowSum = 0;//the window sum
        int start = 0;//start index to start reducing/move the window

        for(int end = 0; end < nums.length; end++) {
            windowSum += nums[end];//end goes until the length of nums
            //and we add it to windowSum every time

            /**
             * When the sliding window's end pointer reaches k - 1, the window has effectively 
             * reached a size of k. This adjustment ensures that the window size is correctly 
             * evaluated before proceeding with the maximum sum calculation.
             */
            if(end >= k - 1) {//we check if the end is equal to or greater than k - 1
                maxSum = Math.max(maxSum, windowSum);//choose maximum between maxSum and windowSum
                windowSum -= nums[start];//subtract the start element from windowSum
                //as we move the window
                start++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum Sum Subarray of Size K: " + findMaxSumSubarray(nums, k));
    }
}
