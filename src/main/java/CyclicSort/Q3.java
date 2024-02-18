package CyclicSort;
//Find all Duplicate Numbers

import java.util.*;

public class Q3 {

    public static List<Integer> findDuplicateNumbers(int[] nums) {
        List<Integer> duplicateNums = new ArrayList<>();

        int i = 0;
        while(i < nums.length) {
            int correctIndex = nums[i] - 1;
            System.out.println("At "+i +" and nums[i] "+nums[i]+ " correct index: " + correctIndex);

            if(nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        //print the nums array
        for(int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        for(i = 0; i < nums.length; i++) {
           if(nums[i] != i + 1) {
               duplicateNums.add(nums[i]);
           }
        }

        return duplicateNums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Duplicate Numbers: "+findDuplicateNumbers(nums));
    }
}
