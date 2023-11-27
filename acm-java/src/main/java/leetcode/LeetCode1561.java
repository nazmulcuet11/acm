package leetcode;

import java.util.Arrays;

public class LeetCode1561 {
    public int maxCoins(int[] piles) {
        int i = 0, j = piles.length - 2;
        Arrays.sort(piles);
        int sum = 0;
        while (i < j) {
            sum += piles[j];
            i += 1;
            j -= 2;
        }
        return sum;
    }
}