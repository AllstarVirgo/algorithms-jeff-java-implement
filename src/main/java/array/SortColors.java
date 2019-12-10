package array;

/**
 * @author potato
 * @Date 2019/12/9 8:51
 */
public class SortColors {
    /**
     * 未能独立完成。
     * 疑难点：先判断0，后判断2，判断2的时候，将后面的0换到前面来，i++,将导致miss掉对0的判断
     *       先判断2，后判断0，判断2的时候，将后面的2换到前面来，导致miss对2 或者1 的判断
     * 解决方案：判断2之后，i回退一次即可
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;
        int p0 = 0, p2 = nums.length - 1;
        int i = 0;
        while (i <= p2) {
            if (nums[i] == 0) {
                exchange(nums, p0, i);
                p0++;
            }
            if (nums[i] == 2) {
                exchange(nums, p2, i);
                p2--;
                i--;
            }
            i++;
        }
    }

    public void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /**
     * [2,1,1,0,0,2]
     */

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors.sortColors(nums);
    }
}
