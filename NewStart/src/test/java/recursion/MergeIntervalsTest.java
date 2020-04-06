package recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeIntervalsTest {

    @Test
    public void sortHelper() {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] test = {{1,3},{2,6},{8,10},{15,18}};
        int[][] test1 = {{2,3},{5,5},{2,2},{3,4},{3,4}};
        mergeIntervals.sortHelper(test1,0,4);
    }
}