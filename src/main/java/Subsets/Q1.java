package Subsets;

//Subsets

import java.util.*;

public class Q1 {

    public static List<List<Integer>> generatedSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    public static void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++) {
              curr.add(nums[i]);
             backtrack(nums, i + 1, curr, subsets);
             System.out.println(curr);
             curr.remove(curr.size() - 1);
             System.out.println(curr);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generatedSubsets(nums);
        System.out.println("Subsets: ");
        for(List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
