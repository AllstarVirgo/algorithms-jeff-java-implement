package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        selectNumberSumToTarget(candidates, target, 0,new ArrayList<>());
        return result;
    }

    void selectNumberSumToTarget(int[] candidates, int target, int index,List<Integer>list) {
        if (0 == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target > 0 && index<candidates.length) {
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                selectNumberSumToTarget(candidates, target - candidates[i], i,list);
                list.remove(list.size() - 1);
            }
        }
    }
}
