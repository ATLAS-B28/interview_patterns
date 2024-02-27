package MBS;

//Next Letter (medium) - modified binary search
/**
 * problem involves finding the next letter in a sorted array of lowercase 
 * letters, which is also known as the smallest 
 * letter that is greater than a given key. 
 * We can use a modified binary search algorithm 
 * to solve this problem efficiently
 * 
 */
public class Q3 {
    
    public static char findNextLetter(char[] chars, char target) {
        int start = 0;
        int end = chars.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("mid: "+mid);

            if(target < chars[mid]) {
                end = mid - 1;
                System.out.println("end: "+end);
            } else {
                start = mid + 1;
                System.out.println("start: "+start);
            }
        }

        System.out.println(chars.length+" & "+start+" then "+chars[start % chars.length]+" where "+(start % chars.length));
        if(start >= chars.length) {
            System.out.println("No next letter");
        }
        return chars[start % chars.length];
    }

    public static void main(String[] args) {
        char[] chars = {'b','c', 'f', 'h'} ;//{'a', 'c', 'f', 'h'};
        char target = 'g';
        char result = findNextLetter(chars, target);
        System.out.println("Next letter of " + target + " is: " + result);
    }
}
