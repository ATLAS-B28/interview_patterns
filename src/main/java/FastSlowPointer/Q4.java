package FastSlowPointer;
//Problem Challenge 1 - Palindrome LinkedList
/*
* The "Palindrome LinkedList" problem involves determining whether
* a given linked list is a palindrome or not. A palindrome is a sequence
* of characters or numbers that reads the same forward and backward.
* */
public class Q4 {

    public static class ListNode3 {
        int val;
        ListNode3 next;

        ListNode3(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode3 findMiddle(ListNode3 head) {
        ListNode3 slow = head;
        ListNode3 fast = head;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode3 reverseList(ListNode3 head) {
        ListNode3 prev = null;
        ListNode3 curr = head;

        while(curr != null) {
            ListNode3 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static boolean isPalindrome(ListNode3 head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode3 middle = findMiddle(head);
        ListNode3 secondHalfReversed = reverseList(middle.next);
        ListNode3 p1 = head;
        ListNode3 p2 = secondHalfReversed;

        while(p2 != null) {
            if(p1.val != p2.val) {
                return false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public static void main(String[] args) {

        ListNode3 head1 = new ListNode3(1);
        head1.next = new ListNode3(2);
        head1.next.next = new ListNode3(3);
        head1.next.next.next = new ListNode3(2);
        head1.next.next.next.next = new ListNode3(1);

        System.out.println(isPalindrome(head1));


    }
}
