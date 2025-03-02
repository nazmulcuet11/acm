package leetcode

class LeetCode2570 {
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        val idToValue = mutableMapOf<Int, Int>()
        for (x in nums1) {
            idToValue[x[0]] = idToValue.getOrDefault(x[0], 0) + x[1]
        }
        for (x in nums2) {
            idToValue[x[0]] = idToValue.getOrDefault(x[0], 0) + x[1]
        }
        val ans = mutableListOf<IntArray>()
        for (k in idToValue.keys.sorted()) {
            ans.add(intArrayOf(k, idToValue[k]!!))
        }
        return ans.toTypedArray()
    }
}