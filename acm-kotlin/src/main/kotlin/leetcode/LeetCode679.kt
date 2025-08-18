package leetcode

import kotlin.math.abs

class LeetCode679 {
    private fun permutations(nums: List<Double>): List<List<Double>> {
        val result = mutableListOf<List<Double>>()
        val taken = mutableSetOf<Int>()

        fun generate(curr: List<Double>) {
            if (curr.size == nums.size) {
                result.add(curr)
                return
            }

            for (i in nums.indices) {
                if (!taken.contains(i)) {
                    taken.add(i)
                    generate(curr + nums[i])
                    taken.remove(i)
                }
            }
        }

        generate(emptyList())

        return result
    }

    fun judgePoint24(cards: IntArray): Boolean {
        fun comb(a: Double, b: Double): List<Double> {
            val result = mutableListOf(
                a + b,
                a - b,
                a * b,
            )
            if (b > 0) {
                result.add(a / b)
            }
            return result
        }

        fun reduce(nums: List<Double>): List<List<Double>> {
            val result = mutableListOf<List<Double>>()
            val x = nums.toMutableList()
            val a = x.removeLast()
            val b = x.removeLast()
            val combs = comb(a, b)
            for (c in combs) {
                result.add(x + listOf(c))
            }
            return result
        }

        var nums = listOf(cards.map { it.toDouble() })
        for (i in 0..<3) {
            val newNums = mutableListOf<List<Double>>()
            for (candidate in nums) {
                val perms = permutations(candidate)
                for (p in perms) {
                    newNums.addAll(reduce(p))
                }
            }
            nums = newNums
        }

//        println(nums.size)

        for (num in nums) {
            if (abs(num[0] - 24.0) < 0.01) {
                return true
            }
        }
        return false
    }
}