package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode2070Test {
    private val sut = LeetCode2070()

    @Test
    fun testCase1() {
        assertContentEquals(
            intArrayOf(2, 4, 5, 5, 6, 6),
            sut.maximumBeauty(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 2),
                    intArrayOf(2, 4),
                    intArrayOf(5, 6),
                    intArrayOf(3, 5),
                ),
                intArrayOf(1, 2, 3, 4, 5, 6)
            )
        )
    }


    @Test
    fun testCase2() {
        assertContentEquals(
            intArrayOf(4),
            sut.maximumBeauty(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 4),
                ),
                intArrayOf(1)
            )
        )
    }


    @Test
    fun testCase3() {
        assertContentEquals(
            intArrayOf(0),
            sut.maximumBeauty(
                arrayOf(
                    intArrayOf(10, 1000),
                ),
                intArrayOf(5)
            )
        )
    }

    @Test
    fun testCase4() {
        assertContentEquals(
            intArrayOf(962, 962, 962, 962, 746, 962, 962, 962, 946, 962, 962, 919, 746, 746, 962, 962, 962, 919, 962),
            sut.maximumBeauty(
                arrayOf(
                    intArrayOf(193, 732),
                    intArrayOf(781, 962),
                    intArrayOf(864, 954),
                    intArrayOf(749, 627),
                    intArrayOf(136, 746),
                    intArrayOf(478, 548),
                    intArrayOf(640, 908),
                    intArrayOf(210, 799),
                    intArrayOf(567, 715),
                    intArrayOf(914, 388),
                    intArrayOf(487, 853),
                    intArrayOf(533, 554),
                    intArrayOf(247, 919),
                    intArrayOf(958, 150),
                    intArrayOf(193, 523),
                    intArrayOf(176, 656),
                    intArrayOf(395, 469),
                    intArrayOf(763, 821),
                    intArrayOf(542, 946),
                    intArrayOf(701, 676)
                ),
                intArrayOf(
                    885,
                    1445,
                    1580,
                    1309,
                    205,
                    1788,
                    1214,
                    1404,
                    572,
                    1170,
                    989,
                    265,
                    153,
                    151,
                    1479,
                    1180,
                    875,
                    276,
                    1584,
                )
            )
        )
    }
}