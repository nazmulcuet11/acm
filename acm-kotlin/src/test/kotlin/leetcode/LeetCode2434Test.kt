package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2434Test {
    private val sut = LeetCode2434()

    @Test
    fun case1() {
        assertEquals(
            "azz",
            sut.robotWithString("zza")
        )
    }

    @Test
    fun case2() {
        assertEquals(
            "abc",
            sut.robotWithString("bac")
        )
    }

    @Test
    fun case3() {
        assertEquals(
            "addb",
            sut.robotWithString("bdda")
        )
    }

    @Test
    fun case4() {
        assertEquals(
            "aaxb",
            sut.robotWithString("baxa")
        )
    }

    @Test
    fun case5() {
        assertEquals(
            "bdevfziy",
            sut.robotWithString("bydizfve")
        )
    }
}