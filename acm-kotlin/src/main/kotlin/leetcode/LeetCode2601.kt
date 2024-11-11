package leetcode

class LeetCode2601 {
    companion object {
        const val MAX_SIZE = 1000 + 5
    }
    private var primes = BooleanArray(MAX_SIZE) { true }
    private fun calculatePrimes() {
        primes[0] = false
        primes[1] = false

        for (i in 2..<MAX_SIZE) {
            if (primes[i]) {
                for (j in i + i..<MAX_SIZE step i) {
                    primes[j] = false
                }
            }
        }
    }

    private fun findMaxPrimeLessThan(n: Int): Int {
        var x = n - 1
        while (x > 0 && !primes[x])
            x--
        return x
    }

    fun primeSubOperation(nums: IntArray): Boolean {
        calculatePrimes()
        val ans = mutableListOf<Int>()
        for (n in nums) {
            val l = if (ans.isEmpty()) 0 else ans.last()
            val primeToSubtract = findMaxPrimeLessThan(n - l)
            if (primeToSubtract < 0 || n - primeToSubtract <= l) {
                return false
            }
            ans.add(n - primeToSubtract)
        }
        return true
    }
}