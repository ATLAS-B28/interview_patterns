class ListNode(var _x: Int = 0) {
    var next: ListNode = null
}
//Problem Challenge 2 - Rearrange a LinkedList (medium)
def reorderList(head: ListNode): Unit = {
    def reverseList(node: ListNode): ListNode = {
        var prev: ListNode = null
        var curr = node

        while(curr != null) {
            val nextTemp = curr.next
            curr.next = prev
            prev = curr
            curr = nextTemp
        }
        prev
    }

    def mergeLists(l1: ListNode, l2: ListNode): Unit = {
        var p1 = l1
        var p2 = l2

        while(p1 != null && p2 != null) {
            val nextTemp1 = p1.next
            val nextTemp2 = p2.next
            p1.next = p2
            p2.next = nextTemp1
            p1 = nextTemp1
            p2 = nextTemp2
        }
        
    }

    var slow = head
    var fast = head

    while(fast != null && fast.next != null) {
        slow = slow.next
        fast = fast.next.next
    }

    var secondHalf = reverseList(slow)
    mergeLists(head, secondHalf)
}

def main(args: Array[String]): Unit = {
    
    val head = new ListNode(1)
    val node1 = new ListNode(2)
    val node2 = new ListNode(3)
    val node3 = new ListNode(4)
    val node4 = new ListNode(5)

    head.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4

    reorderList(head)

    println("Reordered List: ")
    var curr = head
    while(curr != null) {
        println(curr._x)
        curr = curr.next
    }
}
