package dp;

/**
 * @author potato
 * @Date 2019/7/30 9:41
 */
public class EditDistance {
    /**
     * 1. specify sub problems.
     * The key problem is how to align the two Strings.After that it's easy to change one to the other.
     * <p>
     * a1 a2 a3 ... am
     * b1 b2    ... bn
     * <p>
     * Supposing this is the best alignment.So if we cut the last column,the prefixes will still be the
     * shortest edit distance.And it's obvious that the edit distance is only about prefixes.
     * <p>
     * Solving the edit distance problem requires making a sequence of decisions, one for each column
     * in the output alignment.
     * <p>
     * As the edit distance only depend on the prefixes of the two Strings;
     * <p>
     * a1 a2 ... ai ... am
     * b1 b2 ... bj ... bn
     * <p>
     * So we define that Edit(i,j) denotes the edit distance of a[1...i] and b[1...j]
     * <p>
     * There are three cases;
     * Insertion:
     * T E S T |
     * ^ |
     * | |
     * i |
     * T A S T | E
     * ^
     * |
     * j
     * <p>
     * Edit(i,j) = 1+Edit(i,j-1)
     * <p>
     * Deletion:
     * <p>
     * It's like the reversion of insertion.
     * <p>
     * So Edit(i,j) = 1+Edit(i-1,j)
     * <p>
     * Change or Not change:
     * T E S| T                                  T E S| T
     * | ^                                       | ^
     * | |                                       | |
     * | i                                       | i
     * T A S| T  （not change)                   B L O | W  (change)
     * | ^                                       |  ^
     * | |                                       |  |
     * | j                                       |  j
     * <p>
     * In this case,Edit(i,j) = Edit(i-1,j-1)+[A[i]!=B[j]]
     * <p>
     * For i=0 or j=0,we should have special thoughts.
     * <p>
     * when i = 0,Edit(i,j) = j
     * when j = 0,Edit(j,i) = i
     *
     * @param source
     * @param des
     * @return
     */
    public int getEditDistance(String source, String des) {
        int m = source.length();
        int n = des.length();
        char[] sourceChar = source.toCharArray();
        char[] desChar = des.toCharArray();
        int[][] editDistance = new int[m+1][n+1];
        for (int j = 0; j <= n; j++) {
            editDistance[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            editDistance[i][0] = i;
            for (int j = 1; j <= n; j++) {
                int insertion = 1 + editDistance[i][j - 1];
                int deletion = 1 + editDistance[i - 1][j];
                int changeOrNot = editDistance[i - 1][j - 1];
                //For the array sourceChar and desChar,we both use 1 as start index.(not 0)
                if (sourceChar[i-1] != desChar[j-1])
                    changeOrNot += 1;
                editDistance[i][j] = Math.min(Math.min(insertion, deletion), changeOrNot);
            }
        }
        return editDistance[m][n];
    }
}
