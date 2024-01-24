package InPlaceReversalLL;
//Reverse a LinkedLis

public class Q1 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            //2, 3, 4
            ListNode nextTemp = curr.next;
            //curr is 2 and next is 3
            curr.next = prev;
            //and prev is null
            ///than next = null
            //curr is 3
            //prev is 2
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    public static void printLinkedList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        System.out.println("Original List: ");
        printLinkedList(head);

        ListNode reversedHead = reverseList(head);

        System.out.println("Reversed List: ");
        printLinkedList(reversedHead);
    }
}
