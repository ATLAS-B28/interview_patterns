package SlidingWindow;
//Longest Substring with K Distinct Characters

import java.util.HashMap;
public class Q2 {

    public static int findLongestSubstring(String s, int k) {
        int maxLen = 0;
        int start = 0;
        HashMap<Character, Integer> charFreqMap = new HashMap<>();

        for(int end = 0; end < s.length(); end++) {
            char charRight = s.charAt(end);//character at end starting from 0 to end

            charFreqMap.put(charRight, charFreqMap.getOrDefault(charRight, 0) + 1);
            //add the character to the map and check its corresponding frequency
            //if found zero add 1 and if not add simply add 1 to existing frequency
            System.out.println("When we add the character "+ charRight+" to the map: "+charFreqMap);
            while(charFreqMap.size() > k) {
                //check the size of map is greater than k
                char charLeft = s.charAt(start);
                //start from the left
                charFreqMap.put(charLeft, charFreqMap.getOrDefault(charLeft, 0) - 1);
                //then put the character to the map and see the corresponding frequency
                //and if their frequency is 0 or any number exists then -1
                System.out.println("After removing from the left: "+charFreqMap);
                if(charFreqMap.get(charLeft) == 0) {
                //if zero then remove it from the map
                    charFreqMap.remove(charLeft);

                    System.out.println("If found zero for the given character : " +charLeft +" the map is: "+charFreqMap);
                }

                start++;
                System.out.println("After removing the left character: "+charLeft+" the start is: "+start + " and end is: " + end);
                System.out.println("-----------");
                //increment the start by 1
            }
            System.out.println("Max len before update: "+maxLen);
            System.out.println("end: "+end + " & start: "+ start);
            int value = end - start + 1;
            System.out.println("end - start + 1 value: " + value);
            maxLen = Math.max(maxLen, end - start + 1);
            //compare the existing maxLen with the end - start + 1
            /**
             * the expression end - start + 1 represents the length of the current 
             * substring within the window. The end and start pointers mark the 
             * boundaries of the substring, and adding 1 accounts for the inclusive 
             * nature of the substring length calculation,, the addition of 1 to the start 
             * index accounts for the zero-based indexing in the array. 
             * This adjustment ensures that the start index aligns with the next 
             * character in the substring as the window slides to the right.
             */

            System.out.println("At the "+end+" maxLen is "+maxLen);
            System.out.println("------------------------------------");
        }

        return maxLen;
    }

    public  static void main(String[] args) {
        String str = "araaci";
        int k = 2;//max no. of distinct characters in a window at a time 
        //if it exceeds we reduce the element whose frequency is subtracted at each iteration
        //until it goes to zero and meanwhile we the maxlen maintains the last max length of the
        //of the substring with k distinct elements and changes when end - start + 1 is greater then present maxlen
        System.out.println("Longest Substring with K Distinct Characters: "+findLongestSubstring(str, k));
    }
}
