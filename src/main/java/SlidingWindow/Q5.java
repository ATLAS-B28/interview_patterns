package SlidingWindow;
//Problem Challenge 1 - Permutation in a String

import java.util.Arrays;
import java.util.HashMap;

public class Q5 {

    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for(char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
            /*
            * By the end of this loop, the s1Freq array will store the frequency
            * count of each character in the string s1. The index of each character
            * in the s1Freq array is determined by subtracting the ASCII value of
            * 'a' from the corresponding character. This allows us to map each character
            * to a specific index in the array.
            * */
            System.out.println("After the first for loop, for char c = "+ c + " s1Freq[c - 'a'] = "+s1Freq[c - 'a']);
        }

        int start = 0;
        int end = 0;

        while(end < s2.length()) {
            char right = s2.charAt(end);
            System.out.println("right = "+right);
            windowFreq[right - 'a']++;
            System.out.println("windowFreq[right - 'a'] = "+windowFreq[right - 'a']);
            System.out.println("windowFreq: "+ Arrays.toString(windowFreq));

            if(end - start + 1 >= s1.length()) {
                //this if statement means that we have a window of
                //sufficient size to contain a permutation of s1
                if(Arrays.equals(windowFreq, s1Freq)) {
                    return true;
                }

                char left = s2.charAt(start);//represents the character leaving the window
                System.out.println("left = "+left);
                windowFreq[left - 'a']--;//update after the left leaves of the window
                System.out.println("windowFreq[left - 'a'] = "+windowFreq[left - 'a']);
                System.out.println("windowFreq: "+ Arrays.toString(windowFreq));
                start++;
            }

            end++;
        }

        return false;
    }

    public  static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean isPermutation = checkInclusion(s1, s2);
        System.out.println("Is s2 a permutation of s1? "+isPermutation);
    }
}
