package leetcode;

public class BinarySum {
    /**
     * 查找第一个大于目标值的数
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums,int target){
        int lo = 0,hi = nums.length;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[mid] <= target) lo = mid+1;
            else hi = mid;
        }
        return hi;
    }

    /**
     * 查找第一个不小于目标值的数
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums,int target){
        int lo = 0,hi = nums.length;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[mid] < target) lo = mid+1;
            else hi = mid;
        }
        return hi;
    }

}
