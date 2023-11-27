package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode442 {
    public List<Integer> findDuplicates(int[] nums) {
        var ans = new ArrayList<Integer>();
        for (int num: nums) {
            num = Math.abs(num);
            if (nums[num - 1] < 0) {
                ans.add(num);
            } else {
                nums[num - 1] *= -1;
            }
        }
        return ans;
    }
}
