package leetcode

import kotlin.math.min

class LeetCode2033 {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val numbers = grid.flatMap { it.toList() }.sorted()

        for (n in numbers) {
            if (n % x != numbers[0] % x) {
                return -1
            }
        }

        val totalSum = numbers.sum()
        var leftSum = 0
        var minOperation = Int.MAX_VALUE
        for ((i, n) in numbers.withIndex()) {
            var operation = 0
            if (i > 0) {
                operation += i * n - leftSum
            }

            if (i < numbers.size - 1) {
                operation += (totalSum - leftSum - n) - (numbers.size - i - 1) * n
            }

            minOperation = min(operation, minOperation)
            leftSum += n
        }

        return minOperation / x
    }
}