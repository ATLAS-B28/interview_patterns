package FastSlowPointer;
//Happy Number
/*
* A happy number is defined by the following process:
* 1) Starting with any positive integer, replace the number by the sum of the squares of its digits.
* 2) Repeat the process until the number equals 1 (which means it is a happy number) or
*    it loops endlessly in a cycle (which means it is not a happy number).
* */
/*
* Using the example number n = 19,
* the output will be true because the process leads
* to 1: 19 -> 1^2 + 9^2
*      = 82 -> 8^2 + 2^2
*      = 68 -> 6^2 + 8^2
*      = 100 -> 1^2 + 0^2 + 0^2 = 1.
* */
public class Q2 {

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while(fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    public static int getNext(int n) {
        int sum = 0;

        while(n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }
}
