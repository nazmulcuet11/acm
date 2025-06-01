package leetcode

import kotlin.math.min

class LeetCode2929 {
    fun distributeCandies(n: Int, limit: Int): Long {
        // Helper function to count the number of ways to split x candies between 2 people
        // such that neither gets more than 'limit' candies.
        //
        // Case 1: If x > 2 * limit, it's impossible to distribute without one person exceeding the limit → return 0.
        //
        // Case 2: If x <= limit, we can give 0 to x candies to the first person (and the rest to the second),
        //         so there are (x + 1) valid distributions.
        //
        // Case 3: Else, limit < x <= 2 * limit, the first person must get at least (x - limit) candies (so the second doesn't exceed limit),
        //         and at most 'limit' candies (since that's the cap).
        //         So the valid range is: (x - limit) ≤ y ≤ limit
        //         The number of ways = limit - (x - limit) + 1 = 2 * limit - x + 1

        fun countForTwo(x: Int): Long {
            if (x > 2 * limit) {
                return 0
            }

            if (x <= limit) {
                return (x + 1).toLong()
            }

            return (2 * limit - x + 1).toLong()
        }

        var ans = 0L
        // Try giving x candies to the first person and distribute the remaining (n - x) among the other two
        for (x in 0..min(n, limit)) {
            ans += countForTwo(n - x)
        }
        return ans
    }
}