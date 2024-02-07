package MBS;

//Search in a Sorted Infinite Array

public class Q6 {
    
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("mid: "+mid);

            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                end = mid - 1;
                System.out.println("end: "+end);
            } else {
                start = mid + 1;
                System.out.println("start: "+start);
            }
        }

        return -1;
    }

    public static int searchInfiniteArray(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while(arr[end] < target) {
            System.out.println("end: "+end+" start: "+start);
            int newStart = end + 1;
            System.out.println("newStart: "+newStart);
            end = end + (end - start + 1) * 2;
            System.out.println("end: "+end);
            start = newStart;
        }
        return binarySearch(arr, target, start, end);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11,13,15,17,19,19,21,23,25,27,29,33,35,37,39,41,43,43,51,53,55,57,59,61,63,65,67,69,71,73,75,77,79,81,83,85,87,89,91,93,95,97,99};
        int target = 35;
        int result = searchInfiniteArray(arr, target);
        System.out.println("Index of " + target + " is: " + result);
    }
}
