package leetcode;

public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        for (int num: nums) {
            num = Math.abs(num);
            if (nums[num - 1] < 0) {
                return num;
            }
            nums[num - 1] *= -1;
        }
        return 0;
    }
}
