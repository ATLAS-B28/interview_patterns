package TwoPointers;
//Problem Challenge 2 - Comparing Strings containing Backspaces


public class Q6 {

    public static boolean compareStrings(String str1, String str2) {
        int i = 0;
        int j = 0;
        
        while(i < str1.length() && j < str2.length()) {
            if(str1.charAt(i) != str2.charAt(j)) {
                System.out.println("Strings are not equal");
                return false;
            }

            i++;
            j++;
        }

        if(str1.length() == str2.length()) {
           return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str1 = "xzz#";
        String str2 = "xzz#";
        System.out.println("Are the strings equal? "+compareStrings(str1, str2));
    }
}
