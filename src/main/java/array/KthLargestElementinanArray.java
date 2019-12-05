package array;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums,k,0,nums.length-1);
    }

    private int findKthLargest(int[] nums, int k, int lo, int hi) {
        int j = partion(nums,lo,hi);
        if(j<(k-1))
            return findKthLargest(nums,k,j+1,hi);
        else if(j>(k-1))
            return findKthLargest(nums, k,lo,j-1);
        else
            return nums[j];
    }

    private int partion(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int index = lo+1;
        for (int i = lo+1; i <= hi; i++) {
            if(nums[i]>=pivot) {
                exchange(nums, i, index);
                index++;
            }
        }
        exchange(nums,lo,index-1);
        return index-1;
    }

    private void exchange(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        KthLargestElementinanArray kthLargestElementinanArray = new KthLargestElementinanArray();
        kthLargestElementinanArray.findKthLargest(nums,4);
    }
}
