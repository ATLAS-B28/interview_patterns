package MBS;

//Problem Challenge 2 - Search in Rotated Array

public class Q7 {


    public static int searchInRotatedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            System.out.println("mid: "+mid);
            if(arr[mid] == target) {
                return mid;
            }

            //rotated array part is handeled with arr[start] <= arr[mid]
            //and arr[mid] <= arr[end]
            if(arr[start] <= arr[mid]) {//it means the left half is sorted
                System.out.println("arr[mid]: "+arr[mid]+" arr[start]: "+arr[start]);
                if(target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                    System.out.println("end: "+end);
                } else {//if target < arr[start] && target > arr[mid]
                    start = mid + 1;
                    System.out.println("start: "+start);
                }
            } else {//it means the right half is sorted
                System.out.println("arr[mid]: "+arr[mid]+" arr[end]: "+arr[end]);
                if(target > arr[mid] && target < arr[end]) {
                    start = mid + 1;
                    System.out.println("start: "+start);
                } else {//if target < arr[mid] && target > arr[end]
                    end = mid - 1;
                    System.out.println("end: "+end);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = searchInRotatedArray(arr, target);
        System.out.println("Search result: "+result);
    }
    
}
