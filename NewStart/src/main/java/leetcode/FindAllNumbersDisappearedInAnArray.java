package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int curIndex = nums[i]-1;
            while (curIndex>=0){
                int temp =curIndex;
                curIndex = nums[curIndex]-1;
                nums[temp] = -1;
            }
        }

        List<Integer>list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=-1)
                list.add(i+1);
        }
        return list;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAnArray =new FindAllNumbersDisappearedInAnArray();
        int[] test = {4,3,2,7,8,2,3,1};
        findAllNumbersDisappearedInAnArray.findDisappearedNumbers(test);
    }
}
