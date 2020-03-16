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

    //--------------------------------堆排序解法
    public int findKthLargest1(int[] nums, int k) {
        int maxIndex = nums.length-1;
        for(int i = (maxIndex>>1);i>=0;i--){
            minHeapify(nums,i,maxIndex);
        }

        for(int i = maxIndex, j = 0; i>0 && j<k-1 ;i--){
            swap(nums,0,i);
            minHeapify(nums,0,i-1);
            j++;
        }
        return nums[0];
    }

    private void minHeapify(int[] nums,int i,int maxIndex){
        int left = (i<<1) + 1;
        int right = left + 1;
        int max = left;
        if(left>maxIndex)return;
        if(right<=maxIndex && nums[right]>nums[left])
            max = right;
        if(nums[max]>nums[i]){
            swap(nums,max,i);
            minHeapify(nums,max,maxIndex);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        KthLargestElementinanArray kthLargestElementinanArray = new KthLargestElementinanArray();
        System.out.println( kthLargestElementinanArray.findKthLargest1(nums,2));
    }
}
