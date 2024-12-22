package leetcode

import java.util.*

class LeetCode295 {
    private class MaxQueueComparator: Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return if (o1 < o2) {
                1
            } else if (o1 > o2) {
                -1
            } else {
                0
            }
        }
    }

    private val leftQueue = PriorityQueue<Int>(MaxQueueComparator())
    private val rightQueue = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (leftQueue.isEmpty() || num < leftQueue.peek()) {
            leftQueue.add(num)
        } else {
            rightQueue.add(num)
        }

        while ((leftQueue.size - rightQueue.size) > 1) {
            rightQueue.add(leftQueue.poll())
        }

        while ((rightQueue.size - leftQueue.size) > 1) {
            leftQueue.add(rightQueue.poll())
        }
    }

    fun findMedian(): Double {
        if (leftQueue.isEmpty() && rightQueue.isEmpty()) {
            return 0.0
        } else if (leftQueue.size == rightQueue.size) {
            val a = leftQueue.peek().toDouble()
            val b = rightQueue.peek().toDouble()
            return (a + b) / 2.0
        } else if (leftQueue.size > rightQueue.size) {
            return leftQueue.peek().toDouble()
        } else {
            return rightQueue.peek().toDouble()
        }
    }
}