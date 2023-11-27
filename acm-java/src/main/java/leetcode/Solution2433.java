package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2433 {
    public int[] findArray(int[] pref) {
        var ans = new int[pref.length];
        for (int i = 0; i < pref.length; i++) {
            ans[i] = (i == 0 ? 0 : pref[i - 1]) ^ pref[i];
        }
        return ans;
    }
}
