package leetcode;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution1561 {
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