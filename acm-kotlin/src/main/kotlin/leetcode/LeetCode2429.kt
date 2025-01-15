package leetcode

class LeetCode2429 {

    private fun Int.isBitSet(i: Int): Boolean = (this and (1 shl i)) > 0
    private fun Int.setBit(i: Int): Int = this or (1 shl i)

    fun minimizeXor(num1: Int, num2: Int): Int {
        var count = num2.countOneBits()
        var ans = 0
        for (i in 31 downTo 0) {
            if (count == 0) {
                break
            }

            if (num1.isBitSet(i)) {
                ans = ans.setBit(i)
                count--
            }
        }

        for (i in 0..31) {
            if (count == 0) {
                break
            }

            if (!ans.isBitSet(i)) {
                ans = ans.setBit(i)
                count--
            }
        }

        return ans
    }
}