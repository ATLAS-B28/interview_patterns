package CyclicSort;
//Problem Challenge 3 - Find the First K Missing Positive Number

import java.util.*;
public class Q5 {

    public static List<Integer> findFirstMissingPositive(int[] nums, int k) {
        List<Integer> missingNums = new ArrayList<>();

        int i = 0;

        while(i < nums.length) {
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                //we swap the x value in its correct position of x - 1 index
            } else {
                i++;
            }
        }

        Set<Integer> positiveNums = new HashSet<>();
        // This set is used later to find additional missing positive
        // numbers beyond the ones present in the array.
        for(i = 0; i < nums.length &&  missingNums.size() < k; i++) {
            //if 'i' is less then the nums length
            //and missing nums size is less than k
            if(nums[i] != i + 1) {
                //then we check whether element at nums[i] is
                //not equal to i + 1 if so it means that element at index i
                // is not its correct position, therefore i + 1 is a missing number
                //then we add  i + 1 to missing nums
                //and nums[i] to positive nums
                missingNums.add(i + 1);
                positiveNums.add(nums[i]);
                //positive nums -  which helps us keep track of the
                //positive numbers present in the array.
            }
        }

        //We start with i = 1 because we
        //have already checked and added
        //missing positive numbers up to nums.length in the previous
        //for loop
        i = 1;//we start from 1
        // Now, we want to find
        // additional missing positive
        // numbers that are greater than nums.length.
        while(missingNums.size() < k) {
            //and we create a candidate nums where i + nums.length
            //representing the potential missing positive number that we want to check
            int candidateNums = i + nums.length;
            if(!positiveNums.contains(candidateNums)) {
                //if it doesn't contain in positive nums
                //then the candidate nums is missing
                missingNums.add(candidateNums);
                //then at missing nums we add the candidate  nums
            }
            i++;
        }

        return missingNums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, -1, 4, 5, 5};
        int k = 3;
        System.out.println("First " + k + " missing positive numbers: "+findFirstMissingPositive(nums, k));
    }
}
