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
        //here we don't have a traditional linked list but instead
        //a serires of numbers that are replacement of there previous number
        //until we encounter 1 or a cycle
        int slow = n;
        int fast = getNext(n);//get replacement of the current fast

        while(fast != 1 && slow != fast) {
            slow = getNext(slow);//get replacement of the current slow
            fast = getNext(getNext(fast));//get replacemnet of the replacement of the current fast
            //until it reaches 1
        }
//check whether that's the case is 1
        return fast == 1;//final condition
    }

    public static int getNext(int n) {
        int sum = 0;
//we treat the sum of the constituent digits as next number in list
//we do so by dividing the number by 10 and adding the remainder's square
        while(n > 0) {
             int digit = n % 10;
             //get the digit as the remainder of
             // the division i.e. the last digit of the number 
             sum += digit * digit;
             n /= 10;//remove the last digit of the number
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }
}
