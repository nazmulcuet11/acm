package leetcode

class LeetCode3306 {
    private fun Char.isVowel(): Boolean = this in "aeiou"

    private fun countOfSubstringsAtLeastK(word: String, k: Int): Long {
        val vowelCount = mutableMapOf<Char, Int>()
        fun getVowelCount(c: Char) = vowelCount.getOrDefault(c, 0)
        var consonantCount = 0
        fun distinctVowelCount(): Int {
            var count = 0
            for (c in "aeiou") {
                if (getVowelCount(c) > 0) {
                    count++
                }
            }
            return  count
        }
        fun isValid() = distinctVowelCount() == 5 && consonantCount >= k

        var ans = 0L
        var i = 0
        var j = 0
        while (j < word.length) {
            if (word[j].isVowel()) {
                vowelCount[word[j]] = getVowelCount(word[j]) + 1
            } else {
                consonantCount++
            }

            while (isValid()) {
                ans += word.length - j
                if (word[i].isVowel()) {
                    vowelCount[word[i]] = getVowelCount(word[i]) - 1
                } else {
                    consonantCount--
                }
                i++
            }
            j++
        }
        return ans
    }

    fun countOfSubstrings(word: String, k: Int): Long {
        return countOfSubstringsAtLeastK(word, k) - countOfSubstringsAtLeastK(word, k + 1)
    }
}