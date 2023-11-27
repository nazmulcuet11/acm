package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode128 {
    Map<Integer, Integer> rangeStartToRangeEndMap = new HashMap<>();

    void mergeWithOtherRanges(Integer start) {
        var end = rangeStartToRangeEndMap.get(start);
        if (end == null) return;

        var otherEnd = rangeStartToRangeEndMap.get(end + 1);
        if (otherEnd == null) return;

        // remove existing ranges
        rangeStartToRangeEndMap.remove(end + 1);

        // add new range
        rangeStartToRangeEndMap.put(start, otherEnd);

        mergeWithOtherRanges(start);
    }

    public int longestConsecutive(int[] nums) {
        for(int num: nums) {
            rangeStartToRangeEndMap.put(num, num);
        }

        for (int num: nums) {
            mergeWithOtherRanges(num);
        }

        int ans = 0;
        for (var entry: rangeStartToRangeEndMap.entrySet()) {
            ans = Math.max(ans, entry.getValue() - entry.getKey() + 1);
        }

        return ans;
    }
}
