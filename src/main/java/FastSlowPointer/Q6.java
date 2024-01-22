package FastSlowPointer;
//Problem Challenge 3 - Cycle in a Circular Array (hard)
public class Q6 {

   public static boolean hasCycle(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return false;
        }

        for(int i = 0; i < nums.length; i++) {
            int slow = i;
            int fast = i;

            do {
                slow = getNextIndex(nums, slow);
                fast = getNextIndex(nums, fast);

                if(fast != -1) {
                    fast = getNextIndex(nums, fast);
                }
            }while(slow != -1 && fast != -1 && slow != fast);

            if(slow != -1 && slow == fast) {
                return true; // cycle found
            }
        }
        return false;
   }

   public static int getNextIndex(int[] nums, int currIndex) {
        int nextIndex = (currIndex + nums[currIndex]) % nums.length;

        if(nextIndex < 0) {
            nextIndex += nums.length;
        }

        if(nextIndex == currIndex || nums[nextIndex] * nums[currIndex] < 0)  {
            return -1;//same index or different direction, not a cycle
        }

        return nextIndex;
   }


   public static void main(String[] args) {
       int[] nums = { 2, 2, -1, 2 };
       System.out.println(hasCycle(nums));
   }
}