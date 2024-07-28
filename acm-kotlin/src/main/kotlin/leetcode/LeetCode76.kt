package leetcode

class LeetCode76 {
    private fun isValid(a: Map<Char, Int>, b: Map<Char, Int>): Boolean {
        for ((k, v) in b) {
            val c = a.getOrDefault(k, 0)
            if (c < v) {
                return false
            }
        }
        return true
    }

    fun minWindow(s: String, t: String): String {
        val tCharCount = mutableMapOf<Char, Int>()
        for (ch in t) {
            tCharCount[ch] = tCharCount.getOrDefault(ch, 0) +  1
        }

        var minWindowSize = -1
        var minWindowStartIndex = 0
        var currentWindowStartIndex = 0
        var currentWindowEndIndex = 0
        val windowCharCount = mutableMapOf<Char, Int>()
        while (currentWindowEndIndex < s.length) {
            var ch = s[currentWindowEndIndex]
            windowCharCount[ch] = windowCharCount.getOrDefault(ch, 0) +  1

            while (currentWindowStartIndex <= currentWindowEndIndex && isValid(windowCharCount, tCharCount)) {
                val currentWindowSize = currentWindowEndIndex - currentWindowStartIndex + 1
                if (minWindowSize == -1 || currentWindowSize < minWindowSize) {
                    minWindowSize = currentWindowSize
                    minWindowStartIndex = currentWindowStartIndex
                }

                ch = s[currentWindowStartIndex]
                windowCharCount[ch] = windowCharCount.getOrDefault(ch, 0) -  1
                currentWindowStartIndex++
            }

            currentWindowEndIndex++
        }

        if (minWindowSize == -1) {
            return ""
        }
        return s.substring(minWindowStartIndex, minWindowStartIndex + minWindowSize)
    }
}