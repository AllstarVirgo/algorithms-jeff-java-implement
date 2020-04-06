package leetcode;

public class FindFirstandLastPositionOfElementIn {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0,right = n-1,index = -1;
        int[] result = new int[]{-1,-1};
        //search for left
        while(left<=right){
            int mid = (left+right)/2;
            //中间值大于或者等于目标值时，变化right
            if(nums[mid]>=target)right = mid-1;
            else left = mid+1;
            if(nums[mid]==target)index = mid;
        }

        if(index==-1)return result;
        else result[0] = index;

        right = n-1;
        while(left<=right){
            int mid = (left+right)/2;
            //中间值小于或者等于目标值时，变化left
            if(nums[mid]<=target)left = mid+1;
            else right = mid -1 ;
            if(nums[mid]==target)index = mid;
        }
        result[1] = index;
        return result;
    }
}
