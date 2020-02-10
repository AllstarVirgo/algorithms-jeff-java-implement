package dp;

public class MaximumProductSubarray {
    /**
     * 求连续序列的最大积
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int r = nums[0];
        for (int i = 1, max = r, min = r; i < nums.length; i++) {
            //任意两个数乘以同一个负数，会让较小的数变大，较大的数变小
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            r = Math.max(max, r);
        }
        return r;
    }

    /**
     * 求连续序列的最大积
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1,sum = max; i < nums.length ; i++) {
            if(sum<0){
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            if(sum>max)
                max = sum;
        }
        return max;
    }

}
