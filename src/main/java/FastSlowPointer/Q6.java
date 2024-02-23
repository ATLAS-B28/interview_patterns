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

                //The fast pointer is updated an additional time if it is not -1.
                //this is to increase the speed of the fast pointer.
                if(fast != -1) {
                    fast = getNextIndex(nums, fast);
                }
            }while(slow != -1 && fast != -1 && slow != fast);
            //if the fast and slow pointers meet at -1 then the cycle is not found
            //and slow and fast meet at the same index then the cycle is found

            if(slow != -1 && slow == fast) {
                return true; // cycle found
            }
            //else the cycle is found if the fast and slow pointers do not meet
            //at -1 and are equal to each other
        }
        return false;
   }

   public static int getNextIndex(int[] nums, int currIndex) {
        int nextIndex = (currIndex + nums[currIndex]) % nums.length;

        if(nextIndex < 0) {
            nextIndex += nums.length;
        }

        //for the next if loop 

        /*
         * Check if the nextIndex is equal to the currIndex or if the 
         * product of the values at nextIndex and currIndex is less than
         *  0. If either of these conditions is true, it means 
         * that the next index is the same as the current index or the 
         * values at the two indices have different signs, indicating 
         * a different direction. In such cases, the function returns 
         * -1 to indicate that it is not a cycle.
         */

       if(nextIndex == currIndex || nums[currIndex] * nums[nextIndex] < 0) {
         return  -1; // not a cycle
       }

        return nextIndex;
   }


   public static void main(String[] args) {
       int[] nums = { 2, 2, -1, 2 };
       System.out.println(hasCycle(nums));
   }
}