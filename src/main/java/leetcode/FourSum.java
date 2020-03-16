package leetcode;

import java.util.*;

public class FourSum {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int sum = C[i] + D[j];
                map.put(sum, 1 + map.getOrDefault(sum, 0));
            }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int res = map.getOrDefault(-1 * (A[i] + B[j]), 0);
                count += res;
            }
        return count;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } // deduplicate
            for (int j = i + 1; j <= n - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                } // deduplicate
                int tempTarget = target - nums[i] - nums[j];
                int lo = j + 1, hi = n - 1;
                while (lo < hi) {
                    if (tempTarget == nums[lo] + nums[hi]) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo + 1] == nums[lo]) lo++;
                        while (lo < hi && nums[hi - 1] == nums[hi]) hi--;
                        lo++;
                        hi--;
                    } else if (tempTarget < nums[lo] + nums[hi]) {
                        hi--;
                    } else
                        lo++;
                }
            }

        }

        return list;
    }


    public List<List<Integer>> fourSum1(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= n - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } // deduplicate
            for (int j = i + 1; j <= n - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                } // deduplicate
                int sub = target - nums[i] - nums[j];
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == sub) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        } // deduplicate;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < sub) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        fourSum.fourSumCount(A, B, C, D);
    }
}
