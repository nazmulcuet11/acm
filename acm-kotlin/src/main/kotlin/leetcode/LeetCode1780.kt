package leetcode

class LeetCode1780 {
    fun checkPowersOfThree(n: Int): Boolean {
        var x = n
        while (x > 0) {
            if (x % 3 == 2) {
                return false
            }
            x /= 3
        }
        return true
    }
}