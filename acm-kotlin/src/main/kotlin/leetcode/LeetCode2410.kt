package leetcode

class LeetCode2410 {
    fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
        players.sort()
        trainers.sort()
        var j = 0
        var ans = 0
        for (i in players.indices) {
            while (j < trainers.size && trainers[j] < players[i]) {
                j++
            }

            if (j < trainers.size) {
                ans++
                j++
            } else {
                break
            }
        }
        return ans
    }
}