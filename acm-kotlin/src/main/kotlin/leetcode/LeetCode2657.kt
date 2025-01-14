package leetcode

class LeetCode2657 {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val ans = IntArray(A.size) { 0 }
        val count = IntArray(A.size + 1) { 0 }
        var common = 0
        for (i in A.indices) {
            count[A[i]]++
            count[B[i]]++
            if (count[A[i]] == 2) {
                common++
            }
            if (A[i] != B[i] && count[B[i]] == 2) {
                common++
            }
            ans[i] = common
        }
        return ans
    }
}