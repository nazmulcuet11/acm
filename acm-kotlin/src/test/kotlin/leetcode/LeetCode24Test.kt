package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LeetCode24Test {
    private val sut = LeetCode24()

    @Test
    fun testCaseOne() {
        val node1 = LeetCode24.ListNode(1)
        val node2 = LeetCode24.ListNode(2)
        val node3 = LeetCode24.ListNode(3)
        val node4 = LeetCode24.ListNode(4)

        node1.next = node2
        node2.next = node3
        node3.next = node4

        assertEquals(listOf(node2, node1, node4, node3), getListOfNodes(sut.swapPairs(node1)))
    }

    @Test
    fun testCaseTwo() {
        assertEquals(listOf<LeetCode24.ListNode>(), getListOfNodes(sut.swapPairs(null)))
    }

    @Test
    fun testCaseThree() {
        val node1 = LeetCode24.ListNode(1)
        assertEquals(listOf(node1), getListOfNodes(sut.swapPairs(node1)))
    }

    @Test
    fun testCaseFour() {
        val node1 = LeetCode24.ListNode(1)
        val node2 = LeetCode24.ListNode(2)
        val node3 = LeetCode24.ListNode(3)

        node1.next = node2
        node2.next = node3

        assertEquals(listOf(node2, node1, node3), getListOfNodes(sut.swapPairs(node1)))
    }

    private fun getListOfNodes(head: LeetCode24.ListNode?): List<LeetCode24.ListNode> {
        val nodes = mutableListOf<LeetCode24.ListNode>()
        var curr = head
        while (curr != null) {
            nodes.add(curr)
            curr = curr.next
        }
        return nodes
    }
}