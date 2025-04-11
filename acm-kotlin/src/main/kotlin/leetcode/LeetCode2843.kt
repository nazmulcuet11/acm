package leetcode

class LeetCode2843 {
    fun countSymmetricIntegers(low: Int, high: Int): Int {
        fun getDigits(n: Int): List<Int> {
            val digits = mutableListOf<Int>()
            var x = n
            while (x > 0) {
                digits.add(x % 10)
                x /= 10
            }
            return digits.reversed()
        }

        fun isSymmetric(n: Int): Boolean {
            val digits = getDigits(n).toIntArray()
            if (digits.size % 2 == 1) {
                return false
            }

            for (i in 1..<digits.size) {
                digits[i] += digits[i - 1]
            }
            val l = digits.size
            return digits[l - 1] == digits[(l / 2) - 1] * 2
        }

        var count = 0
        for (n in low..high) {
            if (isSymmetric(n)) {
                count++
            }
        }
        return count
    }
}