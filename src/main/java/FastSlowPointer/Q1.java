package FastSlowPointer;
//LinkedList Cycle

class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3(int x) {
        this.next = null;
    }
}
public class Q1 {

    public static boolean hasCycle(ListNode3 head) {
        ListNode3 slow = head;
        ListNode3 fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

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

        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;

        System.out.println(hasCycle(head));

        node4.next = null;

        ListNode3 node1  = new ListNode3(1);
        head.next = node1;
        node1.next = node2;
        node2.next= node0;
        System.out.println(hasCycle(head));
    }
}
