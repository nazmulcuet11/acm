package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode128 {
    static class Range {
        int start, end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int length() {
            return end - start + 1;
        }
    }

    Map<Integer, Range> rangeStartToRangeMap = new HashMap<>();

    Range getMergedRange(Range lhs, Range rhs) {
        return new Range(
            Math.min(lhs.start, rhs.start),
            Math.max(lhs.end, rhs.end)
        );
    }

    void mergeWithOtherRanges(Range range) {
        Range other = rangeStartToRangeMap.get(range.end + 1);
        if (other == null) {
            return;
        }

        // remove existing ranges
        rangeStartToRangeMap.remove(range.start);
        rangeStartToRangeMap.remove(other.start);

        // add new range
        var mergedRange = getMergedRange(range, other);
        rangeStartToRangeMap.put(mergedRange.start, mergedRange);

        mergeWithOtherRanges(mergedRange);
    }

    public int longestConsecutive(int[] nums) {
        for(int num: nums) {
            rangeStartToRangeMap.put(num, new Range(num, num));
        }

        for (int num: nums) {
            mergeWithOtherRanges(new Range(num, num));
        }

        int ans = 0;
        for (var range: rangeStartToRangeMap.values()) {
            ans = Math.max(ans, range.length());
        }

        return ans;
    }
}
