package InPlaceReversalLL;
//Problem Challenge 1 - Reverse alternating K-element Sub-list

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int val) {
        this.val = val;
    }
}
public class Q3 {

    public static ListNode2 reverseAlternatingSubList(ListNode2 head, int k) {
        if(head == null || k <= 1) {
            return head;
        }

        ListNode2 curr = head;
        ListNode2 prev = null;

        while(curr != null) {
            ListNode2 lastNodeOfPrevPart = prev;//represents the current node at the end of sub-list
            ListNode2 lastNodeOfSubList = curr;//last node of sub-list to be reversed

            for(int i = 0; curr != null && i < k; i++) {
                ListNode2 next = curr.next;
                curr.next = prev;
                // updates the next pointer of curr to point to the previous
                // node, effectively reversing the link between curr and
                // the previous node.
                prev = curr;//advancing prev to current node
                curr = next;//advancing curr to next node in the list
            }

            //connect with previous part
            if(lastNodeOfPrevPart != null) {
                lastNodeOfPrevPart.next = prev;//here prev is the first node of the sub-list
            } else {
                head = prev;
            }

            //connect with next part
            lastNodeOfSubList.next = curr;//which represents the next part of the list after reversal

            //skip k nodes in the next iteration
            for(int i = 0; curr != null && i < k; i++) {
                prev = curr;//done to advance the curr to next node
                curr = curr.next;//moves the pointer to the curr's next as current node
            }
            //After the loop finishes, prev will be pointing
            // to the last node of the current sub-list, and
            // curr will be pointing to the node that comes after the current sub-list.
        }

        return head;
    }

    public static void printLinkedList(ListNode2 head) {
        ListNode2 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1);
        ListNode2 second = new ListNode2(2);
        ListNode2 third = new ListNode2(3);
        ListNode2 fourth = new ListNode2(4);
        ListNode2 fifth = new ListNode2(5);
        ListNode2 sixth = new ListNode2(6);
        ListNode2 seventh = new ListNode2(7);
        ListNode2 eighth = new ListNode2(8);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;

        System.out.println("Original linked list:");
        printLinkedList(head);

        // Reverse alternating sub-lists of size 3
        ListNode2 reversedHead = reverseAlternatingSubList(head, 4);

        // Print the linked list with reversed alternating sub-lists
        System.out.println("Linked list with reversed alternating sub-lists:");
        printLinkedList(reversedHead);

    }
}
