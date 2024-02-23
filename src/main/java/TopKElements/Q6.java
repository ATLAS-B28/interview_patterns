package TopKElements;

// Sum of Elements 

import java.util.*;
public class Q6 {

    public static void main(String []args) {

        int[] arr = {3,1,4,1,5,9,2,6,5,3,5};
        int k = 4;//k determines the no. of elements to be summed from the top of the array
        //create max heap
        //using method that returns a comparator that imposes 
        //the reverse of natural ordering on a collection
        //of objects that implements the Comparable interface
        PriorityQueue<Integer> pq = new PriorityQueue<>();
       
        for(int num : arr) {
            System.out.println("numth iteration: " + num);
            pq.add(num);
            System.out.println("top element of pq: " + pq.peek());
        
            if(pq.size() > k) {
                System.out.println("Now adjusting the pq according to the constraints");
                System.out.println("top element of pq when pq.size() > k: " + pq.peek());
                pq.poll();
            } 
        }

        System.out.println("Getting the result");
        int topKSum = 0;
        while(!pq.isEmpty()) {
            System.out.println("top element of pq: " + pq.peek());
            topKSum  += pq.poll();
            System.out.println("Top k sum at each iteration: "+topKSum);
        }

        System.out.println("Sum of top k elements: " + topKSum);

    }
    
}
