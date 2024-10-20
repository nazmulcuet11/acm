package leetcode

/*
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
*/

class LeetCode1545 {
    fun findKthBit(n: Int, k: Int): Char {
        val numberOfBits = (1 shl n) - 1
        val mid = (numberOfBits / 2) + 1

        return if (k == mid) {
            if (k == 1) '0' else '1'
        } else if (k < mid) {
            findKthBit(n - 1, k)
        } else {
            val x = findKthBit(n, numberOfBits - k + 1)
            if (x == '0') '1' else '0'
        }
    }
}