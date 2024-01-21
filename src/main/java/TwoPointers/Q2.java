package TwoPointers;
//Remove Duplicates

import java.util.Arrays;
import java.util.HashSet;
public class Q2 {

    public static int[] removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
            System.out.println("set: "+set);
        }

        int[] result = new int[set.size()];
        int id = 0;

        for(int num : set) {
            result[id++] = num;
            System.out.println("result: "+ Arrays.toString(result));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,4,5,5,6,6,7,8};
        int[] uniqueArr = removeDuplicates(arr);
        System.out.println("Array with unique elements:"+Arrays.toString(uniqueArr));
    }
}
