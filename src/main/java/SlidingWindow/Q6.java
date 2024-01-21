package SlidingWindow;
//Longest Substring with Same Letters after Replacement

import java.util.HashMap;
import java.util.Map;
public class Q6 {

    public static int findLen(String str, int k) {
        int maxLen = 0;
        int maxRepeatCount = 0;
        int start = 0;

        Map<Character, Integer> charFreqMap = new HashMap<>();

        for(int end = 0; end < str.length(); end++) {
            char charRight = str.charAt(end);
            System.out.println("At "+ end + " the character is: " + charRight);
            charFreqMap.put(charRight, charFreqMap.getOrDefault(charRight, 0) + 1);
            maxRepeatCount = Math.max(maxRepeatCount, charFreqMap.get(charRight));
            System.out.println("The map is: " + charFreqMap + " at " + end);
            System.out.println("The maxRepeatCount is: " + maxRepeatCount + " at end: " + end);

            if(end - start + 1 - maxRepeatCount > k) {
                //calculates the no. of characters that need to be replaced
                //to make all the characters the same
                char charLeft = str.charAt(start);
                System.out.println("At "+ start + " the character is: " + charLeft);
                charFreqMap.put(charLeft, charFreqMap.getOrDefault(charLeft, 0) - 1);
                System.out.println("The map is: " + charFreqMap + " at " + start);
                System.out.println("The maxRepeatCount is: " + maxRepeatCount + " at start: " + start);
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
            System.out.println("The maxLen is: " + maxLen + " at end: " + end);
        }
        return maxLen;
    }

    public  static  void main(String[] args) {
        String str = "aabccbb";
        int k = 2;
        System.out.println("Length of the longest substring: " + findLen(str, k));
    }
}
