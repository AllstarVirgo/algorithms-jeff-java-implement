package leetcode;

import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.
 *
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class ShuffleAnArray {

    private int[] original;

    private Random random;

    public ShuffleAnArray(int[] nums) {
        original = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    /**
     * 关于第 51 行代码的注释
     * 若生成的数字j满足j==i,则相应的概率为 1/(i+1)
     * 若生成的数字j不满足j==i，则响应的概率为 (1-1/(i+1))*(1/i) = 1/(i+1)
     * 说明生成的数字在 [0,i]上的概率是相等的，满足均等随机
     * @return
     */
    public int[] shuffle() {
        if(original==null)return null;
        int[] clone= original.clone();
        for(int i = 1;i<original.length;i++){
            int j = random.nextInt(i+1);
            swap(clone,i,j);
        }
        return clone;

    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
