package leetcode

class LeetCode179 {
    private val comparator = Comparator<String> { a, b ->
        return@Comparator if (a + b > b + a) { 
            -1
        } else if (a + b < b + a) {
            1
        } else {
            0    
        }
    }

    fun largestNumber(nums: IntArray): String {
        val numStrs = nums.map(Int::toString).sortedWith(comparator)
        val ans = numStrs.joinToString("").trimStart('0')
        return ans.ifEmpty { "0" }
    }
}