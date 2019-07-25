package dp;

/**
 * @author potato
 * @Date 2019/7/19 8:51
 */
public class LIS {
    /**
     * LISbigger(i, j), which
     * we defined as the length of the longest increasing subsequence of A[ j .. n] in
     * which every element is larger than A[i].
     *
     * @param array
     * @return
     */
    public int lIS(int[] array) {
        int len = array.length;
        int[][] lISTable = new int[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            lISTable[i][len] = 0;
        }
        for (int j = len - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                int take = 1 + lISTable[j][j + 1];
                int skip = lISTable[i][j + 1];
                if (array[j] > array[i])
                    lISTable[i][j] = Math.max(take, skip);
                else
                    lISTable[i][j] = lISTable[i][j+1];
            }
        }
        return lISTable[0][1];
    }
}
