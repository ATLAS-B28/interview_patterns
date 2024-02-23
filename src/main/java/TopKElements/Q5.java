package TopKElements;

//Maximum Distinct Elements

import java.util.*;

public class Q5 {

    public static int findMaxDistinctElements(int[] nums, int k) {

        //nums- array
        //k - the minimum value 
        //below which the element's frequency should be removed
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(freqMap.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());
        System.out.println("sortedList size: " + sortedList.size());
        int count = 0;
        int index = 0;
        while(k > 0 && index < sortedList.size()) {

            //until k is not approaching zero i.e greater then zero and index not reached its end
            /*
            * Enter a while loop that executes as long as k is greater than 0,
            * and the index is less than the size of the sorted
            * frequency map.
            * */
            int freq = sortedList.get(index).getValue();
            if(freq <= k) {
                //check if the frequency is less than or equal to k
                //if so then it means remove all occurrences of this number
                k -= freq;//done by decrementing freq from k and update the k's value
                //remove all occurrences of this number and the while now has k - freq 
                count++;//count keeps track of the removed elements
            } else {
                break;
            }
            index++;
        } 
        System.out.println("count:"+count);

        return sortedList.size() - count;
        /*
        * The final result is obtained by subtracting count
        * from the size of the sorted frequency map. This gives
        * us the maximum number of distinct elements that can be
        * obtained by removing exactly k elements from the original array.
        * */
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 12, 2, 11, 5};
        int k = 3;
 
        /**
         * for the given input values, the maximum distinct elements that can be obtained 
         * after exactly 3 removals would be 2.
         */
        int result = findMaxDistinctElements(nums, k);
        /**
         * On why k - 1 is not done
         * In this specific implementation, k is decremented by the frequency of the 
         * element being considered for removal, rather than k - 1. This allows for 
         * accurate tracking of the remaining available removals. 
         * This approach ensures that the correct number of elements are 
         * removed to maximize the distinct elements remaining in the array.
         * 
         */

        System.out.println("Maximum distinct elements: " + result);
    }
}
