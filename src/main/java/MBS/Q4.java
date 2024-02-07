package MBS;
//Number Range 
public class Q4 {
   
    public static int[] findNumberRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("1st while loop and mid: " + mid);

            if(target <= nums[mid])  {
                end = mid - 1;
                System.out.println("1st while loop and end is: " + end);
            } else {
                start = mid + 1;
                System.out.println("1st while loop and start is: " + start);
            }
        }

        if(start >= nums.length || nums[start] != target) {
            return result;
        }

        result[0] = start;
        System.out.println("start: " + start);

        end = nums.length - 1;
        System.out.println("end: "+end);

        while(start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("2nd while loop and mid: " + mid);

            if(target >= nums[mid]) {
                start = mid  + 1;
                System.out.println("2nd while loop and start is: " + start);
            } else {
                end = mid - 1;
                System.out.println("2nd while loop and end is: " + end);
            }
        }

        System.out.println("end: " + end);
        result[1] = end;

        return result;
    }

    public static void main(String[] args) {
        
        int[] nums = {1, 3, 3, 5, 7, 7, 7, 7, 9, 15};
        int target = 7;
        int[] result = findNumberRange(nums, target);

        System.out.println("Range of " + target + " is from index: " + result[0] + " to index: " + result[1]);
    }
}
