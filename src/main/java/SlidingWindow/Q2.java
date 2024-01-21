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
                //increment the start by 1
            }
            System.out.println("Max len before update: "+maxLen);
            System.out.println("end: "+end + " & start: "+ start);
            int value = end - start + 1;
            System.out.println("end - start + 1 value: " + value);
            maxLen = Math.max(maxLen, end - start + 1);
            //compare the existing maxLen with the end - start + 1

            System.out.println("At the "+end+" maxLen is "+maxLen);
        }

        return maxLen;
    }

    public  static void main(String[] args) {
        String str = "araaci";
        int k = 2;
        System.out.println("Longest Substring with K Distinct Characters: "+findLongestSubstring(str, k));
    }
}
