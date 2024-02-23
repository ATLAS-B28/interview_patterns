package FastSlowPointer;
//Problem Challenge 2 - Rearrange a LinkedList
public class Q5 {
    public static class ListNode4 {
        int val;
        ListNode4 next;

        ListNode4(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode4 findMiddle(ListNode4 head) {
        ListNode4 slow = head;
        ListNode4 fast = head;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public static ListNode4 reverseList(ListNode4 head) {
        ListNode4 prev = null;
        ListNode4 curr = head;

        while(curr != null) {
            ListNode4 next =  curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void mergeLists(ListNode4 head1, ListNode4 head2) {
        while(head1 != null && head2 != null) {
            ListNode4 temp1 = head1.next;
            ListNode4 temp2 = head2.next;

            head2.next = head1.next;
            head1.next = head2;

            head1 = temp1;
            head2 = temp2;
        }
    }

    public static void reorderList(ListNode4 head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode4 middle = findMiddle(head);
        ListNode4 secondHalfReversed = reverseList(middle.next);
        middle.next = null;

        mergeLists(head, secondHalfReversed);
    }

    public static void main(String[] args) {
        ListNode4 head = new ListNode4(1);
        head.next = new ListNode4(2);
        head.next.next = new ListNode4(3);
        head.next.next.next = new ListNode4(4);
        head.next.next.next.next = new ListNode4(5);
        head.next.next.next.next.next = new ListNode4(6);

        reorderList(head);

        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
