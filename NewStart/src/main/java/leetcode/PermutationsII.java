package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, boolean[] used) {
        if(tempList.size()==nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i])continue;
            if(i>0&&(!used[i-1])&&nums[i-1]==nums[i])continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(list,tempList,nums,used);
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }
}
