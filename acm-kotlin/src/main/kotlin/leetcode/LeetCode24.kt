package leetcode

class LeetCode24 {
    class ListNode(var `val`: Int) {
       var next: ListNode? = null
    }

    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val next = head.next
        head.next = swapPairs(next?.next)
        next?.next = head
        return next
    }
}