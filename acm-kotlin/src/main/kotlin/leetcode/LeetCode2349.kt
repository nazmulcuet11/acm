package leetcode

import java.util.*

class LeetCode2349 {
    class NumberContainers() {
        private val indexToNumber = mutableMapOf<Int, Int>()
        private val numberToIndices = mutableMapOf<Int, PriorityQueue<Int>>()

        fun change(index: Int, number: Int) {
            indexToNumber[index] = number
            if (numberToIndices[number] == null) {
                numberToIndices[number] = PriorityQueue()
            }
            numberToIndices[number]?.add(index)
        }

        fun find(number: Int): Int {
            val queue = numberToIndices[number] ?: return -1
            while (queue.isNotEmpty()) {
                val index = queue.peek()
                if (indexToNumber[index] == number) {
                    return index
                } else {
                    queue.poll()
                }
            }
            return -1
        }
    }
}