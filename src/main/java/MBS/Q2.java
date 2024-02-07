package MBS;

//Ceiling of a Number
//finding th ceiling of a number
//in an array refers to loacting the 
//smallest element in the array refers to 
//smallest element in the aarray is greater than or equal
//to a given target value
public class Q2 {

    public static int findCeiling(int[] arr,int target) {
        int start = 0;
        int end = arr.length - 1;

        if(target > arr[end]) {
            return -1;//there is no ceiling
        }

        while(start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("mid: "+ mid);

            if(arr[mid] == target) {
                System.out.println("mid: " + mid);
                return mid;
            } else if(target < arr[mid]) {
                end = mid - 1;
                System.out.println("end: " + end);
            } else {
                start = mid + 1;
                System.out.println("start: " + start);
            }
        }


        System.out.println("start: "+ start);
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {4,6,10,15,20,23};
        int target = 11;
        int result = findCeiling(arr, target);
        System.out.println("Ceiling of " + target + " is at index: " + result);
    }
}
