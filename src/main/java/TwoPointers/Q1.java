package TwoPointers;
//Pair with Target Sum

import java.util.Arrays;
public class Q1 {

    public static  int[] twoSum(int targetSum, int[] arr) {
        Arrays.sort(arr); //Sort the array in ascending order
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            System.out.println("("+left + ") and (" +right+ ")");
            int currSum = arr[left] + arr[right];
            System.out.println("currSum: "+currSum);
            if(currSum == targetSum) {
                return new int[]{left, right};
            } else if (currSum < targetSum) {
                left++;
                System.out.println("left: "+left);
                System.out.println("arr[left]: "+arr[left]);
            } else {
                right--;
                System.out.println("right: "+right);
                System.out.println("arr[right]: "+arr[right]);
            }
        }

        return  new int[]{-1, -1};//No pair found
    }

    public static void main(String[] args) {
        int targetSum = 10;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        int[] result = twoSum(targetSum, arr);
        System.out.println("Pair  with target sum: "+Arrays.toString(result));
    }
}
