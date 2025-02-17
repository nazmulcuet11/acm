package leetcode

class LeetCode1079 {
    private val sequences = mutableSetOf<String>()

    fun solve(
        tiles: String,
        taken: BooleanArray,
        curr: String
    ) {
        sequences.add(curr)
        for (i in taken.indices) {
            if (!taken[i]) {
                taken[i] = true
                solve(tiles, taken, curr + tiles[i])
                taken[i] = false
            }
        }
    }

    fun numTilePossibilities(tiles: String): Int {
        solve(tiles, BooleanArray(tiles.length) { false }, "")
        return sequences.size - 1
    }
}