package leetcode

class LeetCode1007 {
    fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
        // Helper function to count how many rotations are needed
        // to make all elements in array 'a' equal to target 'k'.
        // If not possible, returns Int.MAX_VALUE.
        fun countRotations(k: Int, a: IntArray, b: IntArray): Int {
            var rotation = 0
            for (i in a.indices) {
                if (a[i] == k) {
                    continue
                }

                // If b[i] can be rotated to match k, count a rotation
                if (b[i] == k) {
                    rotation++
                    continue
                }

                // If neither a[i] nor b[i] is k, it's impossible
                return Int.MAX_VALUE
            }
            return rotation
        }

        // Try to make all values equal to tops[0] or bottoms[0],
        // either in tops or bottoms. Take the minimum rotation among all attempts.
        val ans = minOf(
            countRotations(tops[0], tops, bottoms),
            countRotations(bottoms[0], tops, bottoms),
            countRotations(tops[0], bottoms, tops),
            countRotations(bottoms[0], bottoms, tops),
        )

        // If no valid rotation found, return -1
        return if (ans == Int.MAX_VALUE) -1 else ans
    }
}