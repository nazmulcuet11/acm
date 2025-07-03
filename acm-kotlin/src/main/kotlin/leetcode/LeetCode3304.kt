package leetcode

import java.lang.Math.pow
import kotlin.Char
import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.pow

class LeetCode3304 {
    fun kthCharacter(k: Int): Char {
        val noOfOperations = ceil(log2(k.toDouble())).toInt()
        val countAfterAllOperations = 2.0.pow(noOfOperations).toInt()

        fun solve(operation: Int, count: Int, index: Int, offset: Int): Char {
            if (operation == 0) {
                return Char('a'.code + (offset % 26))
            }

            return if (index > count / 2) {
                solve(operation - 1, count / 2, index - count / 2, offset + 1)
            } else {
                solve(operation - 1, count / 2, index, offset)
            }
        }

        return solve(noOfOperations, countAfterAllOperations, k, 0)
    }
}