package leetcode

class LeetCode3042 {
    private fun isPrefixAndSuffix(a: String, b: String): Boolean {
        return b.startsWith(a) && b.endsWith(a)
    }

    fun countPrefixSuffixPairs(words: Array<String>): Int {
        var count = 0
        for (i in words.indices) {
            for (j in i + 1..<words.size) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++
                }
            }
        }
        return count
    }
}