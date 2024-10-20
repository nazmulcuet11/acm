package leetcode

class LeetCode1545 {
    private val numberOfBits = MutableList<Int>(21) { 1 }

    init {
        for (i in 2..20) {
            numberOfBits[i] = numberOfBits[i - 1] * 2 + 1
        }
    }

    private fun findKthBit(n: Int, k: Int, invert: Boolean): Char {
        val x = numberOfBits[n]
        val mid = (x / 2) + 1
        return if (k == mid) {
            var ans = if (k == 1) 0 else 1
            if (invert) {
                ans = if (ans == 0) 1 else 0
            }
            if (ans == 0) '0' else '1'
        } else if (k < mid) {
            findKthBit(n - 1, k, invert)
        } else {
            findKthBit(n - 1, x - k + 1, invert.not())
        }
    }

    fun findKthBit(n: Int, k: Int): Char {
        return findKthBit(n, k, false)
    }
}

/*
S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "0111001 1 0110001"

n = 4, k = 11
15, 11
 */