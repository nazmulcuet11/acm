package leetcode

class LeetCode2683 {
    /*
    Idea:
    d[0] ^ d[1] ^ ... ^ d[n-1]
    =
    (o[0] ^ o[1]) ^ (o[1] ^ o[2]) ^ ... ^ (o[n-1] ^ o[0])
    = 0
    Explanation:
    https://leetcode.com/problems/neighboring-bitwise-xor/solutions/6291582/kotlin-observation-on-beats-100-by-nazmu-w84j/
    */
    fun doesValidArrayExist(derived: IntArray): Boolean {
        var s = 0
        for (n in derived) {
            s = s xor n
        }
        return s == 0
    }
}