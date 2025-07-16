package leetcode

class LeetCode3201 {
    private enum class SequenceType {
        UNIFORM,
        ALTERNATING,
    }

    fun maximumLength(nums: IntArray): Int {
        val n = nums.size

        fun nextParity(parity: Int, sequenceType: SequenceType): Int {
            return when (sequenceType) {
                SequenceType.ALTERNATING -> if (parity == 1) 0 else 1
                SequenceType.UNIFORM -> parity
            }
        }

        fun solve(i: Int, parity: Int, sequenceType: SequenceType): Int {
            if (i == n) return 0

            if (nums[i] % 2 == parity) {
                return solve(i + 1, nextParity(parity, sequenceType), sequenceType) + 1
            } else {
                return solve(i + 1, parity, sequenceType)
            }
        }

        val ans = maxOf(
            solve(0, 0, SequenceType.UNIFORM),
            solve(0, 1, SequenceType.UNIFORM),
            solve(0, 0, SequenceType.ALTERNATING),
            solve(0, 1, SequenceType.ALTERNATING),
        )
        return ans
    }
}