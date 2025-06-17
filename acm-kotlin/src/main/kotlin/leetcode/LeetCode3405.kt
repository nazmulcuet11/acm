package leetcode

class LeetCode3405 {
    /*
    We want to count the number of arrays of length n with exactly k positions
    (i where 1 <= i < n) such that arr[i] == arr[i - 1].

    - There are (n - 1) adjacent positions between elements (i.e., positions from index 1 to n - 1),
      excluding the first element itself.
    - Exactly k of these positions have equal adjacent elements.
    - Therefore, (n - 1 - k) positions have different adjacent elements.

    Step 1:
    Choose the (n - 1 - k) positions where adjacent elements differ.
    This can be done in C(n - 1, n - 1 - k) ways.

    Step 2:
    For each chosen differing position, the element at that position must be different from its previous element.
    Since there are m possible values in total and one is taken by the previous element,
    we have (m - 1) valid choices for each such position.
    Because there are (n - 1 - k) differing positions, the total number of ways to assign values here is:
    (m - 1)^(n - 1 - k).

    Step 3:
    The first element can be any of the m values.

    Combining all:
    Number of good arrays =
    C(n - 1, n - 1 - k) * (m - 1)^(n - 1 - k) * m

    Result is computed modulo 10^9 + 7.
    */
    fun countGoodArrays(n: Int, m: Int, k: Int): Int {
        val mod = 1_000_000_007L

        fun modPow(a: Long, b: Long): Long {
            if (b == 0L) {
                return 1
            }

            val half = modPow(a, b / 2)
            var result = (half * half) % mod
            if (b % 2 == 1L) {
                result = (result * a) % mod
            }
            return result
        }

        fun modPow(a: Int, b: Int): Long = modPow(a.toLong(), b.toLong())

        fun modInverse(a: Long) = modPow(a, mod - 2) // Fermat's Little Theorem

        val factorial = LongArray(n) { 1 }
        for (i in 2..<n) {
            factorial[i] = (factorial[i - 1] * i) % mod
        }

        fun nCr(n: Int, r: Int): Long {
            if (r < 0 || r > n) {
                return 0
            }

            val numerator = factorial[n]
            val denominator = (factorial[r] * factorial[n - r]) % mod
            val inverseDenominator = modInverse(denominator)
            val result = (numerator * inverseDenominator) % mod
            return result
        }


        val numberOfWaysToPickIndices = nCr(n - 1, n - 1 - k)
        val numberOfWaysToFillIndices = modPow(m - 1, n - 1 - k)
        val ans = ((numberOfWaysToPickIndices * numberOfWaysToFillIndices) % mod * m) % mod
        return ans.toInt()
    }
}