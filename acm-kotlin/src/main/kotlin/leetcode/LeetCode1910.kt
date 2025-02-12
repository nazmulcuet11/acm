package leetcode

import java.util.*

/*
class LeetCode1910 {
    private fun removePatternIfMatched(stack: Stack<Char>, part: String) {
        if (part.length > stack.size) {
            return
        }

        val temp = Stack<Char>()
        var i = part.length - 1
        while (i >= 0 && part[i] == stack.last()) {
            i--
            temp.add(stack.pop())
        }

        if (i != -1) {
            // could not find a full match, put back all the popped elements
            while (temp.isNotEmpty()) {
                stack.add(temp.pop())
            }
        }
    }

    fun removeOccurrences(s: String, part: String): String {
        val stack = Stack<Char>()
        for (c in s) {
            stack.add(c)
            removePatternIfMatched(stack, part)
        }
        return stack.joinToString("")
    }
}
*/

class LeetCode1910 {
    private fun computeLPS(p: String): IntArray {
        val lps = IntArray(p.length) { 0 }
        var i = 0
        var j = 1
        while (j < p.length) {
            if (p[i] == p[j]) {
                lps[j] = i + 1
                i++
                j++
            } else if (i == 0) {
                lps[j] = 0
                j++
            } else {
                i = lps[i - 1]
            }
        }
        return lps
    }

    fun removeOccurrences(s: String, part: String): String {
        val lps = computeLPS(part)
        val stack = Stack<Char>()
        val stackLenToPatternIndex = IntArray(s.length + 1) { 0 }
        var i = 0
        var j = 0
        while (i < s.length) {
            if (s[i] == part[j]) {
                stack.add(s[i])
                i++
                j++
                stackLenToPatternIndex[stack.size] = j
                if (j == part.length) {
                    while (j > 0) {
                        stack.pop()
                        j--
                    }
                    j = stackLenToPatternIndex[stack.size]
                }
            } else {
                if (j == 0) {
                    stack.add(s[i])
                    i++
                    stackLenToPatternIndex[stack.size] = 0
                } else {
                    j = lps[j - 1]
                }
            }
        }
        return stack.joinToString("")
    }
}