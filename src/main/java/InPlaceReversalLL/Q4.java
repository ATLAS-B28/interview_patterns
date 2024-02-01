package InPlaceReversalLL;
//Problem Challenge 2 - Rotate a LinkedList

public class Q4 {

    public static class ListNode3 {
        int val;
        ListNode3 next;

        ListNode3(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode3 rotate(ListNode3 head, int k) {
        if(head == null || head.next == null || k <= 0) {
            return head;
        }

        //find length of ll
        int length = 1;
        ListNode3 tail = head;

        while(tail.next != null) {
            tail = tail.next;
            System.out.println("tail.val is "+tail.val);
            length++;
        }
        System.out.println("List length is "+length);

        //determine the no. of rotations needed
        k %= length;

        if(k == 0) {
            return head;
        }

        //find the head and tail of rotated list
        ListNode3 newTail = head;
        for(int i =0; i < length - k - 1; i++) {
            System.out.println("At "+i +" length - k - 1 is " + (length - k - 1) +" and newTail: " + newTail.val);
            //length - k - 1 calculates the index of the new tail node in the
            //original list
            //k is subtracted from length to account for the rotation
            //and - 1 to get the 0-based index
            newTail = newTail.next;
            System.out.println("At "+i +" after assigning to next newTail: " + newTail.val);
        }

        ListNode3 newHead = newTail.next;

        System.out.println("newHead: " + newHead.val);
        System.out.println("newTail: " + newTail.val);
        System.out.println("tail: " + tail.val);
        System.out.println("head: " + head.val);

        //Rotate the list
        tail.next = head;//make the tail's next point to the head
        newTail.next = null;

        return newHead;
    }

    public static void printLinkedList(ListNode3 head) {
        ListNode3 curr = head;

        while(curr != null) {
            System.out.println(curr.val + "->");
            curr = curr.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode3 head = new ListNode3(1);
        head.next = new ListNode3(2);
        head.next.next = new ListNode3(3);
        head.next.next.next = new ListNode3(4);
        head.next.next.next.next = new ListNode3(5);
        head.next.next.next.next.next = new ListNode3(6);

        ListNode3 newHead = rotate(head, 3);

        printLinkedList(newHead);
    }
}
