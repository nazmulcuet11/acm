package leetcode

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class LeetCode93Test {
    private val sut = LeetCode93()

    @Test
    fun testCaseOne() {
        assertEquals(
            listOf("255.255.11.135", "255.255.111.35").sorted(),
            sut.restoreIpAddresses("25525511135").sorted()
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            listOf("0.0.0.0").sorted(),
            sut.restoreIpAddresses("0000").sorted()
        )
    }

    @Test
    fun testCaseThree() {
        assertEquals(
            listOf("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3").sorted(),
            sut.restoreIpAddresses("101023").sorted()
        )
    }
}