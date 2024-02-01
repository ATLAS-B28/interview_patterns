package TopKElements;

//K's Closest Points to the Origin
/*
* To find the K closest points to the origin, you can use a priority
* queue (min-heap) to maintain the K closest points based on their
* distance from the origin.
* */

import java.util.*;

public class Q3 {

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> distFromOrigin(b) - distFromOrigin(a));

        for(int[] point : points) {
            System.out.println(Arrays.toString(point));
            pq.offer(point);//we put the points in the priority queue
            //from largest to smallest
            System.out.println("pq = "+Arrays.toString(pq.peek()));
            if(pq.size() > K) {
                //if he size is greater than K which is k the closest points
                System.out.println("pq.size() = "+pq.size());
                pq.poll();//remove the smallest element
                System.out.println("pq = "+ Arrays.toString(pq.peek()));
            }
        }

        int[][] result = new int[K][2];
        //k rows and 2 columns
        int index = 0;
        while(!pq.isEmpty()) {//until the priority queue is empty

            result[index++] = pq.poll();//fill the result array
            for (int[] ints : result) {
                System.out.println(Arrays.toString(ints));
            }
        }

        return result;
    }

    private static int distFromOrigin(int[] point) {

        System.out.println("point = "+Arrays.toString(point));
        System.out.println("point[0] * point[0] + point[1] * point[1] = "+point[0] * point[0] + point[1] * point[1]);
        return point[0] * point[0] + point[1] * point[1];
        /*
        * By returning the value point[0] * point[0] + point[1] *
        * point[1], the code calculates and returns the square of
        * the Euclidean distance
        * of the given point from the origin.
        * The custom comparator is used to order points based on their distance from the
        * origin. The points with larger distances will be considered
        * "greater" than points with smaller distances.
        * By using the square of the Euclidean distance, you avoid
        * the costly square root operation, as the squared values
        * still maintain the same relative ordering.
        * */
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, -1}, {0, 0}, {2, 6}};
        int K = 3;

        int[][] result = kClosest(points, K);

        System.out.println("K closest points to the origin:");

        for(int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}
