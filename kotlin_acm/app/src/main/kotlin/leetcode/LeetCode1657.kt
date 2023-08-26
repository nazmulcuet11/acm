package leetcode;

public class LeetCode1657 {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length)
            return false

        val charCount1 = hashMapOf<Char, Int>()
        for (ch in word1)
            charCount1[ch] = charCount1.getOrDefault(ch, 0) + 1
        val charCount2 = hashMapOf<Char, Int>()
        for (ch in word2)
            charCount2[ch] = charCount2.getOrDefault(ch, 0) + 1

        return charCount1.keys.sorted() == charCount2.keys.sorted()
                && charCount1.values.sorted() == charCount2.values.sorted()
    }
}
