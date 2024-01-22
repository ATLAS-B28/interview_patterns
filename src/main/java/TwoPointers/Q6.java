package TwoPointers;
//Problem Challenge 2 - Comparing Strings containing Backspaces

import java.util.Stack;
public class Q6 {

    public static boolean compareStrings(String str1, String str2) {
       Stack<Character> stack1 = new Stack<>();
       Stack<Character> stack2 = new Stack<>();

       for(char c : str1.toCharArray()) {
           if(c != '#') {
               stack1.push(c);
           } else if (!stack1.isEmpty()) {
               stack1.pop();
           }
       }

       for(char c : str2.toCharArray()) {
           if(c != '#') {
               stack2.push(c);
           } else if (!stack2.isEmpty()) {
               stack2.pop();
           }
       }

       return stack1.equals(stack2);
    }

    public static void main(String[] args) {
        String str1 = "xy#z";
        String str2 = "xzz#";
        System.out.println("Are the strings equal? "+compareStrings(str1, str2));
    }
}
