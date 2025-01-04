package leetcode

class LeetCode1930 {
    /*
    fun countPalindromicSubsequence(s: String): Int {
        val charToMinIndex = mutableMapOf<Char, Int>()
        val charToMaxIndex = mutableMapOf<Char, Int>()
        for ((i, c) in s.withIndex()) {
            if (charToMinIndex[c] == null) {
                charToMinIndex[c] = i
            }
            charToMaxIndex[c] = i
        }

        val palindromes = mutableSetOf<String>()
        for ((i, c) in s.withIndex()) {
            for (x in 'a'..'z') {
                val minIndex = charToMinIndex.getOrDefault(x, s.length)
                val maxIndex = charToMaxIndex.getOrDefault(x, -1)
                if (i in (minIndex + 1)..<maxIndex) {
                    val p = listOf(x, c, x).toString()
                    palindromes.add(p)
                }
            }
        }
        return palindromes.size
    }
    */

    // alternate solution
    fun countPalindromicSubsequence(s: String): Int {
        val charToMinIndex = mutableMapOf<Char, Int>()
        val charToMaxIndex = mutableMapOf<Char, Int>()
        for ((i, c) in s.withIndex()) {
            if (charToMinIndex[c] == null) {
                charToMinIndex[c] = i
            }
            charToMaxIndex[c] = i
        }

        var ans = 0
        for (x in 'a'..'z') {
            val minIndex = charToMinIndex.getOrDefault(x, s.length)
            val maxIndex = charToMaxIndex.getOrDefault(x, -1)
            val uniqueChars = mutableSetOf<Char>()
            for (i in minIndex + 1..<maxIndex) {
                uniqueChars.add(s[i])
            }
            ans += uniqueChars.count()
        }
        return ans
    }
}