package FastSlowPointer;
//LinkedList Cycle

class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3(int x) {
        this.val = x;
        this.next = null;
    }
}
public class Q1 {

    public static boolean hasCycle(ListNode3 head) {
        ListNode3 slow = head;
        ListNode3 fast = head;
        System.out.println("head :"+head.val+" initial slow: "+slow.val+" fast: "+fast.val);

        while(fast != null && fast.next != null) {
            System.out.println("Before we move the pointers: "+fast.val+" "+fast.next.val);
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("After we move the pointers: "+slow.val + " " + fast.val);
            System.out.println("---------");

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode3 head = new ListNode3(3);
        ListNode3 node2 = new ListNode3(2);
        ListNode3 node0 = new ListNode3(0);
        ListNode3 node4 = new ListNode3(4);
//3 -> 2 -> 0 -> 4 -> 2
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;

        System.out.println(hasCycle(head));

        node4.next = null;
//3 -> 1 -> 2 -> null
        ListNode3 node1  = new ListNode3(1);
        head.next = node1;
        node1.next = node2;
        node2.next= node0;
        node0.next = node4;
        System.out.println(hasCycle(head));
    }
}
