package leetcode

class LeetCode205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        val s2TMap = mutableMapOf<Char, Char>()
        val t2SMap = mutableMapOf<Char, Char>()

        for (i in s.indices) {
            if (s2TMap[s[i]] == null && t2SMap[t[i]] == null) {
                s2TMap[s[i]] = t[i]
                t2SMap[t[i]] = s[i]
            } else if ((s2TMap[s[i]] != null && s2TMap[s[i]] != t[i])
                || (t2SMap[t[i]] != null && t2SMap[t[i]] != s[i])) {
                return false
            }
        }
        return true
    }
}