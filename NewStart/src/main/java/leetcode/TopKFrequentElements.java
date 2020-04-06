package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int[] freq = new int[nums.length+1];
        for(Integer i:map.keySet()){
            int times = map.get(i);
            freq[times] = i;
        }

        List<Integer>result = new ArrayList<>();
        for(int i = nums.length;i>0&&k>0;i--){
            if(freq[i]!=0){
                k--;
                result.add(freq[i]);
            }
        }
        return result;
    }
}
