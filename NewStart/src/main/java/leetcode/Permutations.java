package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>tempList = new ArrayList<>();
        backtrack(result,tempList,nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if(tempList.size()==nums.length)
            result.add(new ArrayList<>(tempList));
        else {
            for(int i=0;i<nums.length;i++){
                if(tempList.contains(nums[i]))continue;
                tempList.add(nums[i]);
                backtrack(result,tempList,nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }


    private void backtack1(List<List<Integer>>result,List<Integer>tempList,int[] nums){
        if(tempList.size()==nums.length){
            result.add(new ArrayList<>(tempList));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i]))continue;
                tempList.add(nums[i]);
                backtack1(result, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
