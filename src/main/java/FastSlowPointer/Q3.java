package FastSlowPointer;
//Middle of the LinkedList
public class Q3 {

    public static  ListNode2 findMiddle(ListNode2 head) {
        ListNode2 slow = head;
        ListNode2 fast = head;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);

        System.out.println("head: "+head.val);

        ListNode2 middle = findMiddle(head);
        System.out.println("middle: "+middle.val);
    }

    public static class ListNode2 {
        int val;
        ListNode2 next;
        ListNode2(int x) {
            this.val = x;
            this.next = null;
        }

    }
}
