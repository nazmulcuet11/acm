package leetcode

import kotlin.math.min

class LeetCode2411 {
    fun smallestSubarrays(nums: IntArray): IntArray {
        val n = nums.size

        val minSetBitIndex = IntArray(64) { n }

        fun Int.isBitSet(bit: Int) = this and (1 shl bit) > 0

        fun Int.setBit(bit: Int) = this or (1 shl bit)

        fun add(index: Int) {
            val x = nums[index]
            for (bit in 0..<64) {
                if (x.isBitSet(bit)) {
                    minSetBitIndex[bit] = min(minSetBitIndex[bit], index)
                }
            }
        }

        fun remove(index: Int) {
            val x = nums[index]
            for (bit in 0..<64) {
                if (x.isBitSet(bit) && minSetBitIndex[bit] == index) {
                    minSetBitIndex[bit] = n
                }
            }
        }

        fun getOr(): Int {
            var res = 0
            for (bit in 0..<64) {
                if (minSetBitIndex[bit] != n) {
                    res = res.setBit(bit)
                }
            }
            return res
        }

        val ans = IntArray(n)
        var i = n - 1
        var j = n - 1
        while (i >= 0) {
            add(i)
            var maxOr = getOr()

            while (j >= i &&  getOr() == maxOr) {
                remove(j)
                j--
            }
            j++
            add(j)

            ans[i] = j - i + 1
            i--
        }

        return ans
    }
}