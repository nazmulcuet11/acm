package leetcode.weekly431

class Question2 {
    private fun mirror(c: Char): Char {
        val offset = c.code - 'a'.code
        val mirrorOffset = 25 - offset
        return Char('a'.code + mirrorOffset)
    }

    fun calculateScore(s: String): Long {
        val charToLastIndex = mutableMapOf<Char, MutableList<Int>>()
        for (c in 'a'..'z') {
            charToLastIndex[c] = mutableListOf()
        }

        var score = 0L
        for ((i, c) in s.withIndex()) {
            val m = mirror(c)
            if (charToLastIndex[m]!!.size > 0) {
                score += i - charToLastIndex[m]!!.last()
                charToLastIndex[m]!!.removeLast()
            } else {
                charToLastIndex[c]!!.add(i)
            }
        }
        return score
    }
}