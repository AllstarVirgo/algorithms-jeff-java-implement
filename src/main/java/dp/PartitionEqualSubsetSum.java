package dp;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        Set<Integer> set = new HashSet<>();
        Set<Integer> setRes = new HashSet<>();
        set.add(sum / 2);
        if ((sum / 2 - nums[0]) == 0)
            return true;
        set.add(sum / 2 - nums[0]);
        for (int i = 1; i < nums.length; i++) {
            setRes.addAll(set);
            for (Integer temp :
                    set) {
                int target = temp - nums[i];
                if (target == 0)
                    return true;
                else if (target > 0) {
                    if (!set.contains(target)) {
                        setRes.add(target);
                    }
                }
            }
            set.addAll(setRes);
        }
        return false;
    }

    public boolean canPartitionFromLeetCode(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        /*
        定义dp[i][j]：j可以又nums的i前个数求和得到
        dp[i][j] = dp[i][j]|dp[i-1][j-nums[i]]
         */
        int n = nums.length;
        sum /= 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        /*0可以又任意前i个数求和得到*/
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i])
                    dp[i][j] = dp[i][j] | dp[i - 1][j - nums[i]];
            }
        }
    }
}
