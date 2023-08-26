package leetcode

class LeetCode151 {
    fun reverseWords(s: String): String {
        val words = s.split(" ")
        return words
            .filter { it.isNotBlank() }
            .reversed()
            .joinToString(" ")
    }
}