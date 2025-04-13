package leetcode

class LeetCode1922 {
    fun countGoodNumbers(n: Long): Int {
        val mod = (1e9 + 7).toLong()

        fun modPow(b: Long, p: Long): Long {
            if (p == 0L) {
                return 1
            }

            var ans = modPow(b, p / 2)
            ans = (ans * ans) % mod
            if (p % 2 == 1L) {
                ans = (ans * b) % mod
            }
            return ans
        }


        val even = n / 2
        val odd = n - even
        val ans = (modPow(5, odd) * modPow(4, even)) % mod
        return ans.toInt()
    }
}