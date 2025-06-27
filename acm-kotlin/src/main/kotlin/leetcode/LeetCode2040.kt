package leetcode

class LeetCode2040 {
    fun kthSmallestProduct(nums1: IntArray, nums2: IntArray, k: Long): Long {
        val neg1 = nums1.filter { it < 0 }.map { it.toLong() }
        val pos1 = nums1.filter { it >= 0 }.map { it.toLong() }
        val neg2 = nums2.filter { it < 0 }.map { it.toLong() }
        val pos2 = nums2.filter { it >= 0 }.map { it.toLong() }

        val totalNegativeProductCount = neg1.size * pos2.size + pos1.size * neg2.size
        val isAnsPositive = k > totalNegativeProductCount
        val targetPosition = if (!isAnsPositive) k else k - totalNegativeProductCount

        fun count(product: Long, a: List<Long>, b: List<Long>): Long {
            var i = 0
            var j = b.size - 1
            var ans = 0L
            while (i < a.size && j >= 0) {
                if (a[i] * b[j] <= product) {
                    ans += j + 1
                    i++
                } else {
                    j--
                }
            }
            return ans
        }

        fun countProductLessThanEqualTo(product: Long): Long {
            return if (isAnsPositive) {
                count(product, pos1, pos2) + count(product, neg1.reversed(), neg2.reversed())
            } else {
                count(product, pos1.reversed(), neg2) + count(product, neg1, pos2.reversed())
            }
        }

        var left = (-1e10).toLong()
        var right = (1e10 + 1).toLong()
        while (left < right) {
            val mid = left + (right - left) / 2
            if (countProductLessThanEqualTo(mid) >= targetPosition) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }
}