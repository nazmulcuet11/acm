package leetcode

import java.util.*

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