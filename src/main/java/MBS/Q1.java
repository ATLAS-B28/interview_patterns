package MBS;
/**
 * Modified binary search refers to variations 
 * of the traditional binary search algorithm 
 * that are adapted to solve specific problems 
 * or work with particular types of data. 
 * These modifications can include handling 
 * arrays with different orders (ascending, 
 * descending, or no specific order), searching 
 * for a target value that may not exist in the 
 * array, or finding the first or last occurrence 
 * of a value within the array.
 * 
 */

//Order-agnostic Binary Search
public class Q1 {

    public static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAscending = arr[start] < arr[end];

        System.out.println(isAscending);
        //i.e. if array's start is smaller then end element
        //then array is sorted in ascending order

       while(start < end) {

        int mid = start + (end - start) / 2;

        System.out.println("mid: "+mid);

        if(arr[mid] == target) {

            return mid;

        }

        if(isAscending) {//if ascending

            System.out.println("arr[mid]: "+arr[mid]);

            if(target < arr[mid]) {//if target less then mid

                end = mid - 1;//change end to mid - 1

                System.out.println("end: "+end);

            } else {//if target greater then mid

                start = mid + 1;//change start to mid + 1

                System.out.println("start: "+start);

            }
        } else {//if not ascending

            System.out.println("arr[mid]: "+arr[mid]);

            if(target > arr[mid]) {//if target greater then mid

                end = mid - 1;//change end to mid - 1

                System.out.println("end: "+end);

            } else {//if target less then mid

                start = mid + 1;//change start to mid + 1

                System.out.println("start: "+start);

            }
        }
       }

       return -1;
    }

    public static void main(String[] args) {
        int[] arr= {3, 5, 7, 9, 1, 90, 100, 130, 140, 160};//{2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int target = 10;
        int result = orderAgnosticBinarySearch(arr, target);
        System.out.println("Element found at index: " + result);
    }
    
}
