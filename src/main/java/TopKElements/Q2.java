package TopKElements;

//Kth Smallest Number



public class Q2 {

    public static int findKthSmallest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return  nums[left];
        }

        int pivotIndex = partition(nums, left, right);

        if(k == pivotIndex) {
            //if pivot index is k itself then return nums[k]
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
            //if k is smaller than pivot index then we recursively call quickSelect on the left side
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
            //if k is greater than pivot index then we recursively call quickSelect on the right side
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        System.out.println("pivot (nums[right]): " + pivot);
        int i = left;
        System.out.println("outside of loop i: " + i);

        for (int j = left; j < right; j++) {
            if(nums[j] <= pivot) {
                System.out.println("Inside of loop j: " + j);
                System.out.println("Inside of loop i: " + i);
                System.out.println("nums[j]: " + nums[j]);
                swap(nums, i, j);
                //swap the i and j if j is smaller than pivot which is nums[right]
                i++;
            }
        }

        swap(nums, i, right);
        //after loop, swap the i and right which is nums[right]

        System.out.println("i: " + i);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 12, 2, 11, 5};
        int k = 3;
        //k becomes k - 1 i.e. 2
        //as array is sorted, and we do k - 1 as array index starts from 0
        //,so we are finding for the k the smallest number

        System.out.println("Find Kth Smallest Number: "+findKthSmallest(nums, k));
        //as array is sorted, and we do k - 1 as array index starts from 0
    }
}
