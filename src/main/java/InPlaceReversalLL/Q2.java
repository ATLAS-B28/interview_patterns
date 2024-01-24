package InPlaceReversalLL;
//Reverse a Sub-list

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int val) {
        this.val = val;
    }
}
public class Q2 {

    private static void printLinkedList(ListNode1 head) {
        ListNode1 curr = head;

        while(curr != null) {
            System.out.println(curr.val + "->");
            curr = curr.next;
        }

        System.out.println("null");
    }

    private static ListNode1 getListNode1(int start, ListNode1 dummy) {
        ListNode1 prev = dummy; //set prev to dummy
        //reason -
        //By setting dummy.next to head, the dummy node acts as a "dummy"
        //or placeholder for the previous node before the sub-list.

        //By using this approach, we can effectively handle the reversal of
        //the sub-list, even if it starts from the first node of the linked list

        //move the prev pointer to the node before the sublist start
        for(int i = 0; i < start - 1; i++) {
            prev = prev.next;
        }
        return prev;
    }


    public static ListNode1 reverseSubList(ListNode1 head, int start, int end) {
        if(head == null || start >= end) {
            return head;
        }

        ListNode1 dummy = new ListNode1(0);
        dummy.next = head;//set dummy's next to the head of the linked list
        final ListNode1 prev = getListNode1(start, dummy);

        //reverse the sublist
        ListNode1 curr = prev.next;
        //curr is the 1st node of the sublist
        //set curr to the node after the sublist start

        //{1,2,3,4,5}
        //start = 2
        //end = 4
        //end - start = 2
        //prev is 1
        //prev.next is 2 which is the 1st node
        //of the sublist and set to curr
        //loop will run for once
        //nextTemp is now pointing to 3
        //curr.next is set to 3's next node i.e. 4
        //and nextTemp.next is set to prev.next i.e. 2
        //and prev.next is set to nextTemp i.e. 3
        for(int i = 0; i < end - start; i++) {
            //end - start times, which represents the length of the sublist
            ListNode1 nextTemp = curr.next;//next node of curr is nextTemp
            curr.next = nextTemp.next;//curr.next is now pointing to it's next node's next
            nextTemp.next = prev.next;//then set the
            prev.next = nextTemp;
        }

        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        ListNode1 second = new ListNode1(2);
        ListNode1 third = new ListNode1(3);
        ListNode1 fourth = new ListNode1(4);
        ListNode1 fifth = new ListNode1(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        System.out.println("Original linked list:");
        printLinkedList(head);

        // Reverse the sub-list from position 2 to 4
        ListNode1 reversedHead = reverseSubList(head, 2, 4);

        // Print the linked list with reversed sub-list
        System.out.println("Linked list with reversed sub-list:");
        printLinkedList(reversedHead);
    }
}
