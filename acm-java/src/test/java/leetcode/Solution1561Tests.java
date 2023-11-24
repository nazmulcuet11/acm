package leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Solution1561Tests {
    Solution1561 sut = new Solution1561();

    @Test
    void testCaseOne() {
        int result = sut.maxCoins(new int[]{2, 4, 5});
        assertEquals(4, result);
    }

    @Test
    void testCaseTwo() {
        int result = sut.maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4});
        assertEquals(18, result);
    }

    @Test
    void testCaseThree() {
        int result = sut.maxCoins(new int[]{2, 4, 1, 2, 7, 8});
        assertEquals(9, result);
    }
}