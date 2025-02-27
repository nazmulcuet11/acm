package leetcode

import kotlin.math.max

class LeetCode873 {
    private var numbers = mutableSetOf<Int>()

    private fun fibonacciLength(a: Int, b: Int): Int {
        fun solve(a: Int, b: Int): Int {
            if (!numbers.contains(a + b)) {
                return 0
            }
            return solve(b, a + b) + 1
        }

        val length = solve(a, b)
        return if (length == 0) {
            0
        } else {
            length + 2 // add 2 for a and b
        }
    }

    fun lenLongestFibSubseq(arr: IntArray): Int {
        for (n in arr) {
            numbers.add(n)
        }

        var maxLength = 0
        for (i in arr.indices) {
            for (j in i + 1..<arr.size) {
                maxLength = max(maxLength, fibonacciLength(arr[i], arr[j]))
            }
        }
        return maxLength
    }
}