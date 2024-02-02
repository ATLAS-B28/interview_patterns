package Subsets;

//Subsets With Duplicates

import java.util.*;

public class Q2 {

    public static List<List<Integer>> subsetWithDup(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                //so until 'i' is greater than start
                //and nums[i] is equal to nums[i - 1]
                //then continue to iterate
                System.out.println("Got the duplicate");
                System.out.println("nums[i]: "+nums[i]);
                System.out.println("nums[i - 1]: "+nums[i - 1]);
                System.out.println("i: "+i);
                System.out.println("i - 1: "+(i - 1));
                System.out.println("start: "+start);
                continue;
                //continue the loop
            }

            //after that add the element
            curr.add(nums[i]);
            //backtrack with the next element
            backtrack(nums, i + 1, curr, subsets);
            //and do the same thing
            //then remove the element from the current position
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 3, 3};
        List<List<Integer>> subsets = subsetWithDup(nums);
        System.out.println("Subsets: ");
        for(List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
