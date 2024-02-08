//LinkedList Cycle
case class ListNode(var _x: Int = 0) {
    var next: ListNode = null;
}

def hasCycle(head: ListNode): Boolean = {
    var slow = head
    var fast = head

    while(fast != null && fast.next != null && fast.next.next != null) {
        slow = slow.next
        fast = fast.next

        if(slow == fast) {
            return true;
        }
    }
    false
}

def main(args: Array[String]): Unit = {
    val head = new ListNode(3)
    val node1 = new ListNode(2)
    val node2 = new ListNode(0)
    val node3 = new ListNode(-4)

    head.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node1

    println("Does the linked list contain a cycle? "+hasCycle(head))
}