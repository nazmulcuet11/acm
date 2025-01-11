package leetcode

class LeetCode1400 {
    fun canConstruct(s: String, k: Int): Boolean {
        val charCount = mutableMapOf<Char, Int>()
        for (c in s) {
            charCount[c] = charCount.getOrDefault(c, 0) + 1
        }

        val oddCount = charCount.count { it.value % 2 == 1 }

        return k in oddCount..s.length
    }
}