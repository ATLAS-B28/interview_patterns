package TwoPointers;

import java.util.Arrays;

public class Q4 {

    public static void sort(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high) {
            System.out.println("mid: "+mid+" arr[mid]: "+ arr[mid]);
            if(arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                System.out.println("low: "+low+" arr[low]: "+ arr[low]);
                mid++;
                System.out.println("mid: "+mid+" arr[mid]: "+ arr[mid]);
            } else if (arr[mid] == 1) {
                mid++;
                System.out.println("mid: "+mid+" arr[mid]: "+ arr[mid]);
            } else {
                //arr[mid] == 2
                swap(arr, mid, high);
                high--;
                System.out.println("high: "+high+" arr[high]: "+ arr[high]);
            }
        }
    }

    private static void swap(int[] arr, int i,  int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 1, 0, 2, 1, 0};
        sort(arr);
        System.out.println("Sorted array: "+Arrays.toString(arr));
    }
}
