package leetcode

class LeetCode1769 {
    /*
    // Brute Force
    fun minOperations(boxes: String): IntArray {
        val ans = IntArray(boxes.length) { 0 }
        for (i in boxes.indices) {
            for (j in 0..<i) {
                if (boxes[j] == '1') {
                    ans[i] += i - j
                }
            }

            for (j in i + 1..<boxes.length) {
                if (boxes[j] == '1') {
                    ans[i] += j - i
                }
            }
        }
        return ans
    }
    */

    fun minOperations(boxes: String): IntArray {
        val ans = IntArray(boxes.length) { 0 }
        var leftTotal = 0
        var leftBallCount = 0
        for (i in boxes.indices) {
            ans[i] = leftTotal
            leftBallCount += if (boxes[i] == '1') 1 else 0
            leftTotal += leftBallCount
        }

        var rightTotal = 0
        var rightBallCount = 0
        for (i in boxes.indices.reversed()) {
            ans[i] += rightTotal
            rightBallCount += if (boxes[i] == '1') 1 else 0
            rightTotal += rightBallCount
        }
        return ans
    }
}