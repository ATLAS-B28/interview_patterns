package TopKElements;

//Maximum Distinct Elements

import java.util.*;

public class Q5 {

    public static int findMaxDistinctElements(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(freqMap.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());

        int count = 0;
        int index = 0;
        while(k > 0 && index < sortedList.size()) {
            /*
            * Enter a while loop that executes as long as k is greater than 0,
            * and the index is less than the size of the sorted
            * frequency map.
            * */
            int freq = sortedList.get(index).getValue();
            if(freq <= k) {
                //check if the frequency is less than or equal to k
                //if so then it means remove all occurrences of this number
                k -= freq;//done by decrementing freq from k
                count++;//count keeps track of the removed elements
            } else {
                break;
            }
            index++;
        }

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

        int result = findMaxDistinctElements(nums, k);

        System.out.println("Maximum distinct elements: " + result);
    }
}
