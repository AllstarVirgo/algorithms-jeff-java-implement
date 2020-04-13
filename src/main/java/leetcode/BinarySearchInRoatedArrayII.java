package leetcode;

public class BinarySearchInRoatedArrayII {
    public boolean search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            System.out.println("left: "+left+" right: "+right+ " mid: "+mid);
            if(nums[mid]>=nums[left]){
                if(nums[mid]<target){
                    left = mid + 1;
                }else if(nums[mid]>target){
                    if(target>=nums[left])
                        right = mid -1;
                    else
                        left = mid + 1;
                }else
                    return true;
            } else {
                if(nums[mid]>target)
                    left = mid + 1;
                else if(nums[mid]<target){
                    if(target<=nums[right])
                        left = mid + 1;
                    else
                        right = mid -1 ;
                }else
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] demo = {1,3,1,1,1};
        BinarySearchInRoatedArrayII bsr = new BinarySearchInRoatedArrayII();
        bsr.search(demo,3);
    }
}
