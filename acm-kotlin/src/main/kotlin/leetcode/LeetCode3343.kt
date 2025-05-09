package leetcode

class LeetCode3343 {
    fun countBalancedPermutations(num: String): Int {
        val n = num.length
        val digits = num.map { it.digitToInt() }
        val total = digits.sum()

        if (total % 2 != 0) {
            return 0
        }

        val mod = 1_000_000_000 + 7

        val frequency = IntArray(10) { 0 }
        for (d in digits) {
            frequency[d]++
        }

        fun modPow(base: Long, exp: Int): Long {
            if (exp == 0) {
                return 1
            }

            var result = modPow(base, exp / 2)
            result = (result * result) % mod
            if (exp % 2 == 1) {
                result = (result * base) % mod
            }
            return result
        }

        fun modInverse(x: Long): Long {
            return modPow(x, mod - 2)
        }

        val factorial = LongArray(n + 1) { 1 }
        val inverseFactorial = LongArray(n + 1) { 1 }
        inverseFactorial[0] = modInverse(factorial[0])
        for (i in 1..n) {
            factorial[i] = (factorial[i - 1] * i) % mod
            inverseFactorial[i] = modInverse(factorial[i])
        }

        val targetSum = total / 2
        val targetOddCount = n / 2
        val targetEvenCount = n - targetOddCount

        val cache = Array(10) { Array(targetOddCount + 1) { LongArray(targetSum + 1) { -1 } } }

        fun solve(digit: Int, currentOddCount: Int, currentOddSum: Int): Long {
            if (digit == 10) {
                return if (currentOddCount == targetOddCount && currentOddSum == targetSum) {
                    (factorial[targetOddCount] * factorial[targetEvenCount]) % mod
                } else {
                    0
                }
            }

            if (cache[digit][currentOddCount][currentOddSum] != -1L) {
                return cache[digit][currentOddCount][currentOddSum]
            }

            var ans = 0L
            for (oddCount in 0..frequency[digit]) {
                if (currentOddCount + oddCount > targetOddCount || currentOddSum + oddCount * digit > targetSum) {
                    continue
                }

                val evenCount = frequency[digit] - oddCount
                val numerator = solve(
                    digit + 1,
                    currentOddCount + oddCount,
                    currentOddSum + oddCount * digit
                )

                val inverseDenominator = (inverseFactorial[oddCount] * inverseFactorial[evenCount]) % mod
                val ways = (numerator * inverseDenominator) % mod
                ans = (ans + ways) % mod
            }

            cache[digit][currentOddCount][currentOddSum] = ans

            return ans
        }

        return solve(0, 0, 0).toInt()
    }
}