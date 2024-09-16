package leetcode

class LeetCode1371 {
    private val charValues = mapOf(
        'a' to 1,
        'e' to 2,
        'i' to 4,
        'o' to 8,
        'u' to 16,
    )

    fun findTheLongestSubstring(s: String): Int {
        val seen = mutableMapOf<Int, Int>()
        var currXor = 0
        var maxLength = 0
        seen[0] = -1
        for ((i, c) in s.withIndex()) {
            val value = charValues.getOrDefault(c, 0)
            currXor = currXor xor value
            seen[currXor]?.let {
                maxLength = maxOf(maxLength, i - it)
            } ?: run {
                seen[currXor] = i
            }
        }
        return maxLength
    }
}