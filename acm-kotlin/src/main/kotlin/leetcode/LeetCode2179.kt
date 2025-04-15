package leetcode

class LeetCode2179 {
    fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {
        val n = nums1.size

        val segTree = LongArray(4 * n + 1) { 0 }

        fun update(idx: Int, segmentStart: Int, segmentEnd: Int, updateIndex: Int) {
            if (updateIndex < segmentStart || segmentEnd < updateIndex) {
                return
            }

            if (segmentStart == segmentEnd) {
                segTree[idx]++
                return
            }

            val m = (segmentStart + segmentEnd) / 2
            update(idx * 2 + 1, segmentStart, m, updateIndex)
            update(idx * 2 + 2, m + 1, segmentEnd, updateIndex)
            segTree[idx] = segTree[idx * 2 + 1] + segTree[idx * 2 + 2]
        }

        fun query(idx: Int, segmentStart: Int, segmentEnd: Int, queryStart: Int, queryEnd: Int): Long {
            if (queryEnd < segmentStart || segmentEnd < queryStart) {
                return 0
            }

            if (queryStart <= segmentStart && segmentEnd <= queryEnd) {
                return segTree[idx]
            }

            val m = (segmentStart + segmentEnd) / 2
            val left =  query(idx * 2 + 1, segmentStart, m, queryStart, queryEnd)
            val right = query(idx * 2 + 2, m + 1, segmentEnd, queryStart, queryEnd)
            return left + right
        }

        val valueToIndex = IntArray(n + 1) { 0 }
        for ((i, x) in nums2.withIndex()) {
            valueToIndex[x] = i
        }

        var count = 0L
        for ((i, x) in nums1.withIndex()) {
            val num2Idx = valueToIndex[x]
            val leftCommonCount = query(0, 0, n - 1, 0, num2Idx)
            val leftUncommonCount = i - leftCommonCount
            val rightCommonCount = n - num2Idx - 1 - leftUncommonCount
            count += leftCommonCount * rightCommonCount

            update(0, 0, n - 1, num2Idx)
        }
        return count
    }
}