package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * 有重复项的解法，时间复杂度 O(n^2logn)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
            for(int j = i+1 ;j<nums.length;j++){
                int target = 0 - nums[i] - nums[j];
                int index = binarySearch(nums,j+1,target);
                if(index!=-1){
                    List<Integer>tempRes = Arrays.asList(nums[i],nums[j],target);
                    res.add(tempRes);
                }
            }
        return res;
    }

    int binarySearch(int[] nums,int j,int target){
        int lo = j;
        int hi = nums.length-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid]==target)
                return mid;
            else if(target<nums[mid])
                hi = mid -1;
            else
                lo = mid+1;
        }
        return -1;
    }

    /**
     * 参考leetcode解法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i==0||i>0&&nums[i]!=nums[i-1]){
                int lo = i+1,hi = nums.length-1,sum = 0 - nums[i];
                while (lo<hi){
                    if(nums[lo]+nums[hi]==sum){
                        List<Integer>result = Arrays.asList(nums[lo],nums[hi],nums[i]);
                        results.add(result);
                        while (lo<hi&&nums[lo+1] == nums[lo])lo++;
                        while (lo<hi&&nums[hi-1] == nums[hi])hi--;
                        lo++;
                        hi--;
                    }else if(nums[lo]+nums[hi]<sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return results;
    }


}
