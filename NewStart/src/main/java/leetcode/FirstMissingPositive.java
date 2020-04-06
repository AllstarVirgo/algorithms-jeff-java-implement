package leetcode;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //将小于0或者大于n的数字特殊标记为n+1
        //对于这两种情况，它们不会影响 缺失的第1个正数
        for(int i = 0;i<n;i++){
            if(nums[i]<=0||nums[i]>n){
                nums[i] = n+1;
            }
        }

        for(int i = 0;i<n;i++){
            //可能为负数，因为后面在做相反数的工作
            int num = Math.abs(nums[i]);
            //不关心特殊标记的值
            if(num>n)continue;

            int index = num-1;
            //防重复
            if(nums[index]>0)
                nums[index] = -1*nums[index];
        }


        for(int i=0;i<n;i++){
            if(nums[i]>0)
                return i+1;
        }

        return n+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        int[] demo = {3,4,-1,1};
        fmp.firstMissingPositive(demo);
    }
}
