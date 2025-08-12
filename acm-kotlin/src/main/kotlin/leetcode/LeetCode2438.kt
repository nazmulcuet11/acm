package leetcode

class LeetCode2438 {
    companion object {
        const val MOD = (1_000_000_000 + 7).toLong()
    }

    fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
        fun getPowers(): List<Long> {
            val res = mutableListOf<Long>()
            var x = n
            var p = 1L
            while (x > 0) {
                if (x % 2 == 1) {
                    res.add(p)
                }
                x /= 2
                p *= 2
            }
            return res
        }

        fun modPower(b: Long, p: Long): Long {
            if (p == 0L) {
                return 1
            }

            var res = modPower(b, p / 2)
            res = (res * res) % MOD
            if (p % 2 == 1L) {
                res = (res * b) % MOD
            }
            return res
        }

        fun modInverse(b: Long) = modPower(b, MOD - 2)

        val powers = getPowers()

        val prodPowers = powers.toMutableList()
        for (i in 1..<powers.size) {
            prodPowers[i] = (prodPowers[i] * prodPowers[i - 1]) % MOD
        }

        val inverseProdPowers = powers.toMutableList()
        inverseProdPowers[powers.size - 1] = modInverse(prodPowers[powers.size - 1])

        for (i in inverseProdPowers.size - 2 downTo 0) {
            inverseProdPowers[i] = (inverseProdPowers[i + 1] * powers[i + 1]) % MOD
        }

        // println(powers)
        // println(prodPowers)
        // println(inverseProdPowers)

        val ans = mutableListOf<Int>()
        for (q in queries) {
            val l = q[0]
            val r = q[1]
            var res = prodPowers[r]
            if (l > 0) {
                res = (res * inverseProdPowers[l - 1]) % MOD
            }
            ans.add(res.toInt())
        }
        return ans.toIntArray()
    }
}