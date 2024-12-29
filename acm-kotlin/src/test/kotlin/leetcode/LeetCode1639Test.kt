package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1639Test {
    private val sut = LeetCode1639()

    @Test
    fun case1() {
        assertEquals(
            6,
            sut.numWays(
                arrayOf("acca", "bbbb", "caca"),
                "aba"
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4,
            sut.numWays(
                arrayOf("abba", "baab"),
                "bab"
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            677452090,
            sut.numWays(
                arrayOf(
                    "cbabddddbc",
                    "addbaacbbd",
                    "cccbacdccd",
                    "cdcaccacac",
                    "dddbacabbd",
                    "bdbdadbccb",
                    "ddadbacddd",
                    "bbccdddadd",
                    "dcabaccbbd",
                    "ddddcddadc",
                    "bdcaaaabdd",
                    "adacdcdcdd",
                    "cbaaadbdbb",
                    "bccbabcbab",
                    "accbdccadd",
                    "dcccaaddbc",
                    "cccccacabd",
                    "acacdbcbbc",
                    "dbbdbaccca",
                    "bdbddbddda",
                    "daabadbacb",
                    "baccdbaada",
                    "ccbabaabcb",
                    "dcaabccbbb",
                    "bcadddaacc",
                    "acddbbdccb",
                    "adbddbadab",
                    "dbbcdcbcdd",
                    "ddbabbadbb",
                    "bccbcbbbab",
                    "dabbbdbbcb",
                    "dacdabadbb",
                    "addcbbabab",
                    "bcbbccadda",
                    "abbcacadac",
                    "ccdadcaada",
                    "bcacdbccdb"
                ),
                "bcbbcccc"
            )
        )
    }
}