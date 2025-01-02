package leetcode

class LeetCode2559 {
    private companion object {
        const val vowels = "aeiou"
    }

    private fun Char.isVowel() = vowels.contains(this)

    private fun String.isVowelString() = first().isVowel() && last().isVowel()

    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val count = IntArray(words.size) { 0 }
        for ((i, w) in words.withIndex()) {
            count[i] = if (w.isVowelString()) 1 else 0
            if (i > 0) {
                count[i] += count[i - 1]
            }
        }

        val ans = IntArray(queries.size) { 0 }
        for ((i, q) in queries.withIndex()) {
            ans[i] = count[q[1]]
            if (q[0] > 0) {
                ans[i] -= count[q[0] - 1]
            }
        }
        return ans
    }
}