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
            System.out.println("nums[k]: " + nums[k]);
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
        int i = left;//keeps the boundry between the 2 partitions
        System.out.println("outside of loop i: " + i);

        /**
         * 
         * By swapping the elements, the algorithm ensures that all elements less than or 
         * equal to the pivot are moved to the left side of the array, while elements greater 
         * than the pivot remain on the right side. This process effectively partitions
         * the array into two parts, with elements less than or equal to the pivot on the 
         * left, and elements greater than the pivot on the right.
         */
        for (int j = left; j < right; j++) {
            if(nums[j] <= pivot) {
                System.out.println("Inside of loop j: " + j);
                System.out.println("Inside of loop i: " + i);
                System.out.println("nums[j]: " + nums[j]);
                swap(nums, i, j);
                //swap the i and j if j is smaller than pivot which is nums[right]
                //this is to maintain the partitioning logic of the QuickSelect algorithm.
                i++;
                System.out.println("i in if statement: " + i);
            }
        }

        swap(nums, i, right);//we are placing the pivot at the right index so we swap it with ith element


        //after loop, swap the i and right which is nums[right]

        System.out.println("i: " + i);
        for(int num : nums) {
            System.out.println(num + " ");
        }
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        System.out.println("Swapping i:" + i +" " + nums[i] + " and j:" + j + " " + nums[j]);
        nums[i] = nums[j];
        System.out.println("Swapped i:" + i +" " + nums[i] + " and j:" + j + " " + nums[j]);
        nums[j] = temp;
        System.out.println("Swapped i:" + i +" " + nums[i] + " and j:" + j + " " + nums[j]);
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 12, 3, 11, 5};
        int k = 3;
        //k becomes k - 1 i.e. 2
        //as array is sorted, and we do k - 1 as array index starts from 0
        //,so we are finding for the k the smallest number

        System.out.println("Find Kth Smallest Number: "+findKthSmallest(nums, k - 1));
        //as array is sorted, and we do k - 1 as array index starts from 0
    }
}
