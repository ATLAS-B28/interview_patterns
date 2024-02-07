package MBS;

//Problem Challenge 3 - Rotation Count

public class Q8 {
   
    public static int findRotationCount(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            if(nums[start] <= nums[end]) {
                return start;//not rotated
            }

            int mid = start + (end - start) / 2;
            int next = (mid  + 1) % nums.length;
            int prev = (mid + nums.length - 1) % nums.length;

            System.out.println("mid: "+mid+" next: "+next+" prev: "+prev);
            
            if(nums[mid] <= nums[next] && nums[mid] <= nums[prev])/**
            This indicates that the mid element is minimum element
            in the array */ {
                System.out.println("mid: "+mid+" nums[mid]: "+nums[mid]+" next: "+next+" nums[next]: "+nums[next]+" prev: "+prev+" nums[prev]: "+nums[prev]);
                return mid; //found the pivot
            } else if(nums[mid] <= nums[prev]) {
                System.out.println("mid: "+mid+" nums[mid]: "+nums[mid]+" prev: "+prev+" nums[prev]: "+nums[prev]);
                //mid element is less then previous element
                end = mid - 1;//search in the left half
            } else if(nums[mid] >= nums[next]) {
                System.out.println("mid: "+mid+" nums[mid]: "+nums[mid]+" next: "+next+" nums[next]: "+nums[next]);
                //mid element is greater then next element
                start = mid + 1;//search in the right half
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        //{5, 6, 7, 8, 9, 10, 11, 12, 13, 14};//{6, 7, 8, 9, 10, 11, 12, 13, 14};//{15, 18, 2, 3, 6, 12};
        int result = findRotationCount(arr);
        System.out.println("Rotation Count: "+result);
    }
}
