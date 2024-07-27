package leetcode

class LeetCode30 {
    // checks if we can have substring starting at `startIndex`
    // that is a permutation of the words
    private fun check(
        s: String,
        startIndex: Int,
        wordLength: Int,
        wordCount: Int,
        wordMap: Map<String, Int>
    ): Boolean {
        if (startIndex + wordCount * wordLength > s.length) {
            return  false
        }

        var i = startIndex
        val mutableWordMap = wordMap.toMutableMap()
        for (j  in 0..<wordCount) {
            val w = s.substring(i..<i+wordLength)
            when (val c = mutableWordMap.getOrDefault(w, 0)) {
                0 -> {
                    return false
                }
                1 -> {
                    mutableWordMap.remove(w)
                }
                else -> {
                    mutableWordMap[w] = c - 1
                }
            }
            i += wordLength
        }
        return mutableWordMap.isEmpty()
    }

    private fun run(
        s: String,
        startIndex: Int,
        wordLength: Int,
        wordCount: Int,
        wordMap: Map<String, Int>
    ): List<Int> {
        val ans = mutableListOf<Int>()
        var i = startIndex
        while (i < s.length) {
            if (check(s, i, wordLength, wordCount, wordMap)) {
                ans.add(i)
            }
            i += wordLength
        }
        return ans
    }

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val ans = mutableListOf<Int>()
        val wordMap = mutableMapOf<String, Int>()
        val wordLength = words[0].length
        for (w in words) {
            wordMap[w] = wordMap.getOrDefault(w, 0) + 1
        }
        for (i in 0..<wordLength) {
            ans.addAll(run(s, i, wordLength, words.size, wordMap))
        }
        return ans
    }
}