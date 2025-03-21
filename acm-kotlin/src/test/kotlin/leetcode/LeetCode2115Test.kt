package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode2115Test {
    private val sut = LeetCode2115()

    @Test
    fun case1() {
        assertContentEquals(
            listOf("bread"),
            sut.findAllRecipes(
                arrayOf("bread"),
                listOf(
                    listOf("yeast", "flour")
                ),
                arrayOf("yeast", "flour", "corn")
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            listOf("bread", "sandwich"),
            sut.findAllRecipes(
                arrayOf("bread", "sandwich"),
                listOf(
                    listOf("yeast", "flour"),
                    listOf("bread", "meat")
                ),
                arrayOf("yeast", "flour", "meat")
            )
        )
    }

    @Test
    fun case3() {
        assertContentEquals(
            listOf("bread", "sandwich", "burger"),
            sut.findAllRecipes(
                arrayOf("bread", "sandwich", "burger"),
                listOf(
                    listOf("yeast", "flour"),
                    listOf("bread", "meat"),
                    listOf("sandwich", "meat", "bread")
                ),
                arrayOf("yeast", "flour", "meat")
            )
        )
    }
}