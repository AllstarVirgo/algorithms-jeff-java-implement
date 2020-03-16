package leetcode;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length - 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (l<r && nums[l] <= nums[l + 1]) l++;
        if (l == r) return 0;
        while (nums[r] >= nums[r - 1]) r--;
        for (int i = l; i <= r; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        while (l>=0 && nums[l] > min) l--;
        while (r<nums.length && nums[r] < max) r++;
        return (r-1)-(l+1)+1;
    }
}
