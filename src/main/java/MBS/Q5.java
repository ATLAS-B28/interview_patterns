package MBS;

//Minimum Difference Element (medium) - Find 
//the floor & ceil take the difference, 
//minimum would be the ans
/**
 * problem involves finding the element in a sorted 
 * array with the minimum difference from a given number. 
 * This problem can be solved by finding the floor and 
 * ceiling of the given number in the array, and then 
 * calculating the differences to find the minimum.
 * 
 */
public class Q5 {

    public static int findMinimumDifference(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("mid: "+mid);

            if(arr[mid] == target) {
                return arr[mid];
            } else if(target < arr[mid]) {
                end = mid - 1;
                System.out.println("end: "+end);
            } else {
                start = mid + 1;
                System.out.println("start: "+start);
            }
        }

        if(start > 0 && end < arr.length - 1) {
            int diff1 = Math.abs(target - arr[start]);
            int diff2 = Math.abs(target - arr[end]);
            System.out.println("diff1: "+diff1+" diff2: "+diff2);
            return (diff1 < diff2) ? arr[start] : arr[end];
        } else if(start > 0) {
            System.out.println("start: "+start);
            return arr[start];
        } else {
            System.out.println("end: "+end);
            return arr[end];
        }
    }
    

    public static void main(String[] args) {
        int[] arr = {2,4,7,9,12};//{1, 3, 8, 10, 15};
        int target = 6;
        int result = findMinimumDifference(arr, target);
        System.out.println("Minimum difference element: " + result);
    }
}
