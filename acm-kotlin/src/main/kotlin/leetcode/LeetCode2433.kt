package leetcode

class LeetCode2433 {
    fun findArray(pref: IntArray): IntArray {
        return (0..< pref.count())
            .map { i ->
                (if (i > 0) pref[i - 1] else 0) xor pref[i]
            }
            .toIntArray()
    }
}