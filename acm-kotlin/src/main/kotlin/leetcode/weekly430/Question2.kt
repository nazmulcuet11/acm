package leetcode.weekly430

import kotlin.math.min

class Question2 {
    fun answerString(word: String, numFriends: Int): String {
        if (numFriends == 1) return word
        val maxWordLength = word.length - (numFriends - 1)
        var ans = word.substring(0, maxWordLength)
        for (i in word.indices) {
            val t = word.substring(i, min(word.length, i + maxWordLength))
            if (t > ans) {
                ans = t
            }
        }
        return ans
    }
}

fun main() {
    val sut = Question2()
    val ans = sut.answerString("aann", 2)
    println(ans)
}