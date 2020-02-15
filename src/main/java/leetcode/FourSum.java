package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSum {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length,count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                int sum = C[i]+D[j];
                map.put(sum,1+map.getOrDefault(sum,0));
            }

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                int res = map.getOrDefault(-1*(A[i]+B[j]),0);
                count += res;
            }
        return count;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};
        fourSum.fourSumCount(A,B,C,D);
    }
}
