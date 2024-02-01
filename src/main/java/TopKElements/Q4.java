package TopKElements;

//Kth Largest Number in a Stream

import java.util.PriorityQueue;

public class Q4 {

    public static int[] findTopKElements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] kLargest = new int[k];
        int index = k - 1;
        //k - 1 because we want the k largest elements
        while(!pq.isEmpty()) {
            kLargest[index--] = pq.poll();
            //here we do the index -- because we want the k largest elements
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
