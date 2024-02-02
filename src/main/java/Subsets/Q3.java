package Subsets;

//Permutations with subset approach

import java.util.*;

public class Q3 {

    public static  List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], permutations);
        return permutations;
    }

    private static void backtrack(int[] nums, List<Integer> curr, boolean[] used, List<List<Integer>> permutations) {
        if(curr.size() == nums.length) {
            permutations.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
                /*
                * If used[i] is true, it means that the element has
                * already been included in the current permutation, so we
                * skip to the next iteration using the continue statement.
                * */
            }
            // if not, then add it to the current permutation
            // This adds the current element to the current permutation being built.
            curr.add(nums[i]);//nums[i] is the current element
            used[i] = true;
            backtrack(nums, curr, used, permutations);
            // Backtrack with the next element
            /*
            * We make a recursive call to the backtrack function
            * with the updated curr list and used array.
            * This recursive call explores the next level of the
            * recursion, considering the remaining elements that
            * haven't been used yet
            * */
            used[i] = false;
            curr.remove(curr.size() - 1);
            // remove the last element so that we can try other possibilities
            // for the next element
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);
        System.out.println("Permutations: ");
        for(List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
