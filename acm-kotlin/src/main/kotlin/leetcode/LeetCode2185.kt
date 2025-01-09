class LeetCode2185 {
    fun prefixCount(words: Array<String>, pref: String): Int {
        var count = 0
        for (w in words) {
            if (w.startsWith(pref)) {
                count++
            }
        }
        return count
    }
}
