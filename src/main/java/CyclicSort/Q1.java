package CyclicSort;
//Cyclic Sort (easy)
//introduction to cyclic sort
public class Q1 {

    public static void cyclicSort(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int correctIndex = nums[i]  - 1;//calculates where current element at i needs to be placed
            System.out.println("At "+i + " correct index: " + correctIndex);
            if(nums[i] != nums[correctIndex]) {
                //check if it is at the correct index or not
                //if not then swap
                swap(nums, i , correctIndex);
            } else {//else it is at its correct index
                i++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        System.out.println("Swapping " + nums[i] + " and " + nums[j]);
        nums[i] = nums[j];
        nums[j] = temp;
        System.out.println("Swapped " + nums[i] + " and " + nums[j]);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 4, 2};
        cyclicSort(nums);
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}
