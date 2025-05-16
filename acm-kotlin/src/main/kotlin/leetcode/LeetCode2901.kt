package leetcode

class LeetCode2901 {
    fun getWordsInLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        fun isValid(i: Int, j: Int): Boolean {
            if (groups[i] == groups[j]) {
                return false
            }

            if (words[i].length != words[j].length) {
                return false
            }

            var hammingDistance = 0
            for (k in words[i].indices) {
                if (words[i][k] != words[j][k]) {
                    hammingDistance++
                }
            }

            return hammingDistance == 1
        }

        val dp = IntArray(words.size) { -1 }
        val prev = IntArray(words.size) { -1 }
        for (i in words.indices) {
            var maxLen = 0
            var maxJ = -1
            for (j in 0..<i) {
                if (isValid(j, i)) {
                    if (dp[j] > maxLen) {
                        maxLen = dp[j]
                        maxJ = j
                    }
                }
            }

            dp[i] = maxLen + 1
            prev[i] = maxJ
        }

        var maxEndIndex = 0
        for (i in dp.indices) {
            if (dp[i] > dp[maxEndIndex]) {
                maxEndIndex = i
            }
        }

        val ans = mutableListOf<String>()
        var curr = maxEndIndex
        while (curr != -1) {
            ans.add(words[curr])
            curr = prev[curr]
        }
        return ans.reversed()
    }
}