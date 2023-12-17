package leetcode

class LeetCode72 {
    private var cache = HashMap<Pair<Int, Int>, Int>()
    private var word1 = ""
    private var word2 = ""
    private fun minDistance(i: Int, j: Int): Int {
        if (i == -1 && j == -1) {
            return 0
        } else if (i == -1) {
            return j + 1
        } else if (j == -1) {
            return i + 1
        }

        val key = Pair(i, j)
        cache[key]?.let {
            return it
        }

        val ans = if (word1[i] == word2[j]) {
            minDistance(i - 1, j -1)
        } else {
            1 + minOf(
                minDistance(i - 1, j -1),
                minDistance(i, j - 1),
                minDistance(i - 1, j)
            )
        }

        cache[key] = ans
        return ans
    }
    fun minDistance(word1: String, word2: String): Int {
        this.word1 = word1
        this.word2 = word2
        this.cache = HashMap()
        return minDistance(word1.length - 1, word2.length - 1)
    }
}