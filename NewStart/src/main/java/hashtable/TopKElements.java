package hashtable;

import java.util.*;

public class TopKElements {
/*
    Given a non-empty array of integers, return the k most frequent elements.

            Example 1:

    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
    Example 2:

    Input: nums = [1], k = 1
    Output: [1]
    */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for (int n:nums){
            frequencyMap.put(n,frequencyMap.getOrDefault(n,0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(Integer n:frequencyMap.keySet()){
            int frequency = frequencyMap.get(n);
            if(bucket[frequency]==null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(n);
        }
        List<Integer>res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
       int[] test = {1,2,3,3,3};
       List<Integer>res = topKFrequent(test,1);
       res.stream().forEach(System.out::print);
    }
}
