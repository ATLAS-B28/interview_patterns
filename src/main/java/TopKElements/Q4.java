package TopKElements;

//Kth Largest Number in a Stream

import java.util.PriorityQueue;

public class Q4 {

    public static int[] findTopKElements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
 
        /**
         * When using a min-heap to find the kth largest element, 
         * after adding elements to the priority queue, we need to ensure that the 
         * size of the queue does not exceed k. If it does, we can remove the smallest
         * element (at the front of the queue) by calling the poll method. This ensures 
         * that the queue always contains the k largest elements.
         * By polling k times from the min-heap, we effectively remove 
         * the k smallest elements from the queue, leaving the k largest 
         * elements in the queue. As a result, the kth largest element will 
         * be at the front of the queue.
         * 
         */
        for(int num : nums) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] kLargest = new int[k];
        int index = k - 1;
        //k - 1 because we want the k largest elements and account for zero indexing
        while(!pq.isEmpty()) {
            kLargest[index--] = pq.poll();
            //here we do the index-- because we want the k largest elements in descending order
        }

        return kLargest;
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 12, 2, 11, 5};
        int k = 3;

        int[] result = findTopKElements(nums, k);

        System.out.println("K largest elements: ");
        for(int num : result) {
            System.out.print(num + " ");
        }
    }

}
