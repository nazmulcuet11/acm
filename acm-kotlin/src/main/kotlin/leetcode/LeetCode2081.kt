package leetcode

import sun.security.util.Length

class LeetCode2081 {
    fun kMirror(k: Int, n: Int): Long {
        fun isPalindrome(digits: List<Int>, i: Int, j: Int): Boolean {
            if (i >= j) return true
            if (digits[i] != digits[j]) return false
            return isPalindrome(digits, i + 1, j - 1)
        }

        fun isKMirror(number: Long): Boolean {
            val digits = mutableListOf<Int>()
            var number = number
            while (number > 0) {
                val rem = number % k
                digits.add(rem.toInt())
                number /= k
            }
            return isPalindrome(digits, 0, digits.size - 1)
        }

        var ans = 0L
        var count = 0
        val digits = IntArray(100) { 0 }

        fun mapToInt(length: Int): Long {
            var sum = 0L
            for (i in 0..<length) {
                sum = sum * 10 + digits[i]
            }
            return sum
        }

        fun generateAndAdd(i: Int, j: Int, length: Int) {
            if (count == n) {
                return // no need to generate more
            }

            if (i > j) {
                val number = mapToInt(length)
                if (isKMirror(number)) {
                    ans += number
                    count++
                }
                return
            }

            val start = if (i == 0) 1 else 0
            for (d in start..9) {
                digits[i] = d
                digits[j] = d
                generateAndAdd(i + 1, j - 1, length)
            }
        }

        var length = 1
        while (count < n) {
            generateAndAdd(0, length - 1, length)
            length++
        }

        return ans
    }
}