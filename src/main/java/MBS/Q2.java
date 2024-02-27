package MBS;

//Ceiling of a Number
//finding th ceiling of a number
//in an array refers to loacting the 
//an element in the array refers to 
//finding the smallest element greater than or equal
//to a given target value
public class Q2 {

    public static int findCeiling(int[] arr,int target) {
        int start = 0;
        int end = arr.length - 1;

        if(target > arr[end]) {
            return -1;//there is no ceiling
        }

        while(start <= end) {
            int mid = start + (end - start ) / 2;
            
            if(target == arr[mid]) {
                return mid;
            } else if(target <= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }


        System.out.println("start: "+ start);
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {4,6,10,15,20,23};
        int target = 16;
        int result = findCeiling(arr, target);
        System.out.println("Ceiling of " + target + " is at index: " + result);
    }
}
/**
 * Initialize start to 0, end to 5 (arr.length - 1).
  Since the target (11) is less than the last element of the array (23), we proceed with the binary search.
Calculate the mid index: (0 + (5 - 0)) / 2 = 2. (Value at index 2 is 10)    - 
  Since the value at index 2 (10) is less than the target (11), we update start to mid + 1, so start becomes 3.
Calculate the new mid index: (3 + (5 - 3)) / 2 = 4. (Value at index 4 is 20)    - 
  Since the value at index 4 (20) is greater than the target (11), we update end to mid - 1, so end becomes 3.
Calculate the new mid index: (3 + (3 - 3)) / 2 = 3. (Value at index 3 is 15)    - 
  Since the value at index 3 (15) is greater than the target (11), we update end to mid - 1, so end becomes 2.

The start index (3) is returned as the result, as it represents the smallest element in the
array that is greater than or equal to the target value.
 * 
 */