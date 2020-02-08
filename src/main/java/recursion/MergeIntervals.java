package recursion;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) return intervals;
        sortHelper(intervals, 0, len - 1);
        List<int[]> result = new ArrayList<>();
        int index = 0;
        result.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] cur = intervals[i];
            int[] last = result.get(index);
            if (cur[0] > last[1]) {
                result.add(cur);
                index++;
            } else {
                result.remove(index);
                int hi = Math.max(cur[1], last[1]);
                int lo = Math.min(cur[0], last[0]);
                int[] tempRes = {lo, hi};
                result.add(tempRes);
            }
        }
        int[][] mergeRes = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            mergeRes[i] = result.get(i);
        }
        return mergeRes;
    }

    void sortHelper(int[][] intervals, int lo, int hi) {
        if ((hi - lo) > 0) {
            int p = partion(intervals, lo, hi);
            sortHelper(intervals, lo, p - 1);
            sortHelper(intervals, p + 1, hi);
        }
    }

    int partion(int[][] intervals, int lo, int hi) {
        int smallerPoint = lo + 1, pivot = intervals[lo][0];
        for (int i = lo + 1; i <= hi; i++) {
            if (intervals[i][0] < pivot) {
                exchange(intervals, smallerPoint, i);
                smallerPoint++;
            }
        }
        exchange(intervals, smallerPoint-1, lo);
        return --smallerPoint;
    }

    void exchange(int[][] intervals, int i, int j) {
        int[] temp = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = temp;
    }
}
