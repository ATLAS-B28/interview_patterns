package CyclicSort;

//Problem Challenge 2 - Find the Smallest Missing Positive Number

public class Q4 {

    public static int findSmallestMissingPositive(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            int correctIndex = nums[i] - 1;
            System.out.println("At "+i +" and nums[i] "+nums[i]+ " correct index: " + correctIndex);
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
                //responsible for placing the element at its correct position
                //i.e. at x - 1 index
            } else {
                i++;
            }
        }

        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                System.out.println("At " + i + " nums[i] " + nums[i]);
                //i + 1 represents the expected value at index i
                //it checks if elements at index i is not equal to i + 1
                //if true then it means that the smallest missing positive number
                //is at index 'i'
                //purpose of this check is to determine if the element at index i
                //is in its correct position , if not then it implies that the
                //smallest missing positive number is i + 1.
                System.out.println("Smallest missing positive number: " + (i + 1));
                return  i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 4, 2};
        System.out.println("Smallest missing positive number: "+findSmallestMissingPositive(nums));
    }
}
