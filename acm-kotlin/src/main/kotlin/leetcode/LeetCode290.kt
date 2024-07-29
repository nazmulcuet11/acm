package leetcode

class LeetCode290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")
        if (words.size != pattern.length) {
            return false
        }

        val charToWordMap = mutableMapOf<Char, String>()
        val wordToCharMap = mutableMapOf<String, Char>()

        for (i in pattern.indices) {
            val c = pattern[i]
            val w = words[i]

            if (wordToCharMap.containsKey(w) && charToWordMap.containsKey(c)) {
                if (wordToCharMap[w] != c || charToWordMap[c] != w) {
                    return false
                }
            } else if (wordToCharMap.containsKey(w) || charToWordMap.containsKey(c)) {
                return false
            } else {
                charToWordMap[c] = w
                wordToCharMap[w] = c
            }
        }

        return true
    }
}