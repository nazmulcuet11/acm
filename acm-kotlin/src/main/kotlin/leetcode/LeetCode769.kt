package leetcode

import kotlin.math.max

/*
// Brute force: O(N^3)
class LeetCode769 {
    private fun nextPartitionPoint(arr: List<Int>, start: Int): Int {
        for (i in start + 1..<arr.size) {
            val left = arr.subList(start, i).sorted()
            val right = arr.subList(i, arr.size).sorted()
            val whole = arr.subList(start, arr.size).sorted()
            if (left + right == whole) {
                return i
            }
        }
        return arr.size
    }

    fun maxChunksToSorted(arr: IntArray): Int {
        var count = 0
        var i = 0
        while (i < arr.size) {
            i = nextPartitionPoint(arr.asList(), i)
            count++
        }
        return count
    }
}
*/

/*
// Optimal: O(N)
class LeetCode769 {
    fun maxChunksToSorted(arr: IntArray): Int {
        val minRight = arr.copyOf()
        minRight[arr.size - 1] = arr[arr.size - 1]
        for (i in arr.size - 2 downTo 0) {
            minRight[i] = min(minRight[i + 1], arr[i])
        }

        var count = 0
        var maxLeft = -1
        for (i in arr.indices) {
            maxLeft = max(maxLeft, arr[i])
            if (i == arr.size - 1 || maxLeft < minRight[i + 1]) {
                count++
            }
        }
        return count
    }
}
*/

// Optimal: O(N) alternative
class LeetCode769 {
    fun maxChunksToSorted(arr: IntArray): Int {
        var count = 0
        var maxLeft = -1
        for (i in arr.indices) {
            maxLeft = max(maxLeft, arr[i])
            if (i == maxLeft) {
                count++
            }
        }
        return count
    }
}