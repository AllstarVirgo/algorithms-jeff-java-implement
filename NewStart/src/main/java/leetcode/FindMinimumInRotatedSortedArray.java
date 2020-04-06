package leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null||nums.length==0)return 0;
        int left =0,right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if(mid>0 && nums[mid]<nums[mid-1])
                return nums[mid];
            //大于等于，是考虑mid==left的情况，最小值应该在右边
            if(nums[mid]>=nums[left] && nums[mid]>nums[right])
                left = mid + 1;
            else
                right = mid -1;
        }
        return nums[left];
    }

    public int simplerFindMin(int[] nums){
        if(nums == null||nums.length==0)return 0;
        int left =0,right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            //the mininum is in the right part
            if(nums[mid]>nums[right])
                left = mid + 1;
            //the mininum is in the left part
            else if(nums[mid] < nums[right])
                //not mid-1
                right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray findAllNumbersDisappearedInAnArray = new FindMinimumInRotatedSortedArray();
        int[] demo = {1,2,3,4};
        findAllNumbersDisappearedInAnArray.findMin(demo);
    }
}
