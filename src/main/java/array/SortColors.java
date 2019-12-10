package array;

/**
 * @author potato
 * @Date 2019/12/9 8:51
 */
public class SortColors {
    /**
     * Input: [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * It is hard to define what is a "one-pass" solution but this algorithm is bounded by O(2n),
     * meaning that at most each element will be seen and operated twice (in the case of all 0s).
     * You may be able to write an algorithm which goes through the list only once, but each step
     * requires multiple operations, leading the total operations larger than O(2n).
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;
        int p0 = 0, p2 = nums.length - 1;
        int i = 0;
        while (i <= p2 && p0 <= p2) {
            while (nums[i] == 2 && p0 <= p2) {
                exchange(nums, p2, i);
                p2--;
            }
            i++;
            while (nums[i] == 0 && p0 <= p2) {
                exchange(nums, p0, i);
                p0++;
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
