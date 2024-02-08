//Start of LinkedList Cycle
case class ListNode2(var _x: Int = 0 ) {
    var next: ListNode2 = null;
}

def detectCycle(head: ListNode2): ListNode2 = {
    var slow = head;
    var fast = head;
    var hasCycle = false;

    while(fast != null && fast.next != null && fast.next.next != null && !hasCycle) {
        slow = slow.next
        fast = fast.next.next

        if(slow == fast) {
            hasCycle = true
        }
    }

    if(!hasCycle) {
        return null
    }

    slow = head

    while(slow != fast) {
        slow = slow.next
        fast  =fast.next
    }

    slow
    
}

def main(args: Array[String]): Unit = {
    val head = new ListNode2(3)
    val node1 = new ListNode2(2)
    val node2 = new ListNode2(0)
    val node3 = new ListNode2(-4)

    head.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node1

    println("Cycle detected at "+detectCycle(head)._x)
}
