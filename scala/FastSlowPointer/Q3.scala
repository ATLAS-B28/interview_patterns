//Problem Challenge 1 - Palindrome LinkedList

class ListNode(var _x: Int = 0) {
    var next: ListNode = null
}

def isPalindrome(head: ListNode): Boolean = {

    def reverseList(node: ListNode): ListNode = {
        var prev: ListNode = null
        var curr = node

        while(curr != null) {
            val nextTemp = curr.next
            curr.next=  prev
            prev = curr
            curr = nextTemp
        }
        prev
    }
 
   
    var slow = head
    var fast = head

    while(fast != null && fast.next != null) {
        slow = slow.next
        fast = fast.next.next
    }
    if(fast != null) slow = slow.next

    var p1 = head
    var p2 = reverseList(slow)

    while(p2 != null) {
        if(p1._x != p2._x) return false
        p1 = p1.next
        p2 = p2.next
    }
    true
}

def main(args: Array[String]): Unit = {
    
    val head = new ListNode(1)
    val node1 = new ListNode(2)
    val node2 = new ListNode(2)
    val node3 = new ListNode(1)

    head.next = node1
    node1.next = node2
    node2.next = node3

    println("Is Palindrome: "+isPalindrome(head))

}
