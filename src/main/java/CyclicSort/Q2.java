package CyclicSort;
//Find all Missing Numbers (easy)

import java.util.*;
public class Q2 {

    public static List<Integer> findMissingNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

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

        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                System.out.println("At " + i + " nums[i] " + nums[i]);
                System.out.println("Missing Number: " + (i + 1));
                missingNumbers.add(i + 1);
            }
        }

        return missingNumbers;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 8, 2, 3, 5, 1};
        System.out.println("Missing Numbers: "+findMissingNumbers(nums));
    }
}
