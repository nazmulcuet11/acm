package leetcode

class LeetCode3539 {
    fun magicalSum(m: Int, k: Int, nums: IntArray): Int {
        val mod = 1_000_000_000L + 7L
        val n = nums.size

        fun setBitCount(a: Long): Int {
            var a = a
            var bitCount = 0
            while (a > 0) {
                if (a and 1 > 0) {
                    bitCount++
                }
                a = a shr 1
            }
            return bitCount
        }

        fun setBitCount(a: Int) = setBitCount(a.toLong())

        fun pow(b: Long, p: Long): Long {
            if (p == 0L) return 1
            val h = pow(b, p / 2)
            var r = (h * h) % mod
            if (p % 2 == 1L) {
                r = (r * b) % mod
            }
            return r
        }

        fun pow(a: Int, b: Int) = pow(a.toLong(), b.toLong())

        fun modInverse(a: Long): Long = pow(a, mod - 2)

        val fact = MutableList<Long>(m + 1) { 1 }
        val invFact = MutableList<Long>(m + 1) { 1 }

        fact[0] = 1
        for (i in 1..m) {
            fact[i] = (fact[i - 1] * i) % mod
        }

        invFact[m] = modInverse(fact[m])
        for (i in m downTo 1) {
            invFact[i - 1] = (invFact[i] * i) % mod
        }

        fun comb(n: Int, r: Int): Long {
            return ((fact[n] * invFact[r]) % mod * invFact[n - r]) % mod
        }

        val cache = List(n) {
            List(m + 1) {
                List(k + 1) {
                    MutableList(m + 1) {
                        -1L
                    }
                }
            }
        }

        fun solve(
            i: Int,
            targetNumCount: Int,
            targetBitCount: Int,
            carry: Int,
        ): Long {

            if (i >= n || targetNumCount <= 0 || targetBitCount <= 0) {
                return if (targetNumCount == 0 && setBitCount(carry) == targetBitCount) 1 else 0
            }

            //  println("i: $i, targetNumCount: $targetNumCount, targetBitCount: $targetBitCount, carry: $carry")

            if (cache[i][targetNumCount][targetBitCount][carry] != -1L) {
                return cache[i][targetNumCount][targetBitCount][carry]
            }

            var sum = 0L
            for (freq in 0..targetNumCount) {
                val total = carry + freq
                val t = solve(
                    i + 1,
                    targetNumCount - freq,
                    targetBitCount - (total and 1),
                    total shr 1
                )
                val p = pow(nums[i], freq)
                val c = comb(targetNumCount, freq)
                val prod = ((p * c) % mod * t) % mod
                sum = (sum + prod) % mod
            }
            cache[i][targetNumCount][targetBitCount][carry] = sum
            return sum
        }

        return solve(0, m, k, 0).toInt()
    }
}