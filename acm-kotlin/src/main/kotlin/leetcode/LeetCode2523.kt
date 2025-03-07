package leetcode

class LeetCode2523 {
    fun closestPrimes(left: Int, right: Int): IntArray {
        val isPrime = BooleanArray(right + 1) { true }
        isPrime[1] = false
        var i = 2
        while (i * i <= right) {
            if (isPrime[i]) {
                var j = i + i
                while (j <= right) {
                    isPrime[j] = false
                    j += i
                }
            }
            i++
        }

        var minDiff = right - left + 1
        var prev = -1
        val ans = intArrayOf(-1, -1)
        for (x in left..right) {
            if (isPrime[x]) {
                if (prev != -1) {
                    val diff = x - prev
                    if (diff < minDiff) {
                        minDiff = diff
                        ans[0] = prev
                        ans[1] = x
                    }
                }
                prev = x
            }
        }
        return ans
    }
}