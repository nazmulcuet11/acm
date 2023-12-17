package leetcode

class Solution49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()
        for (str in strs) {
            val key = str.toCharArray().sorted().joinToString()
            if (!map.contains(key)) {
                map[key] = mutableListOf()
            }
            map[key]?.add(str)
        }
        return map.values.toList()
    }
}