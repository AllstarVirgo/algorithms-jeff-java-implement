package leetcode;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i = 0;i<(n-1);i++){
            int index = findIndex(numbers,i+1,n-1,target-numbers[i]);
            if(index!=-1){
                return new int[]{i+1,index+1};
            }
        }
        return null;
    }

    int findIndex(int[] nums,int i,int j,int target){
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid]>target)j = mid -1;
            else if(nums[mid]<target)i = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int[] twoSumLC(int[] numbers, int target) {
        int left = 0,right = numbers.length-1;
        while (left<right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1,right+1};
            }else if(sum>target)
                right--;
            else
                left++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] test = {2,7,11,15};
        TwoSumII tw = new TwoSumII();
        tw.twoSum(test,9);
    }
}
