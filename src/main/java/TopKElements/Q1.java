package TopKElements;

//Top 'K' Numbers

import java.util.PriorityQueue;

public class Q1 {

    public static  int[] findTopKNumbers(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            //add the first k elements to the min heap
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            //then we start from the kth element
            //and compare it with the top element of the min heap
            if(nums[i] > minHeap.peek()) {
                //if current element in nums[i] (which start form kth index) is greater than
                //that at the top of the min heap
                //remove it from the min heap
                //and add the current element
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        int[] topK = new int[k];

        //add the top most k elements from the min heap
        for (int i = 0; i < k; i++) {
            topK[i] = minHeap.poll();
        }

        return topK;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 5, 12, 2, 11};
        int k = 3;

        int[] topK = findTopKNumbers(nums, k);

        System.out.print("Top " + k + " numbers are: ");

        for (int i : topK) {
            System.out.print(i + " ");
        }
    }
}
