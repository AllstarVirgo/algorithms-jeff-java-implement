package backtrack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author potato
 */
public class NQueens {

    public List<int[]>resList = new ArrayList<>();

    public void placeNQueens(int[] q, int r) {
        if (r == q.length) {
            int[] res = Arrays.stream(q).toArray();
            resList.add(res);
        } else {
            //all possible places from 0 to q.length-1
            for (int i = 0; i < q.length; i++) {
                boolean legal = true;
                for (int j = 0; j < r; j++) {
                    if (q[j] == i || q[j] == i + r - j || q[j] == i + j - r)
                        legal = false;
                }
                if (legal) {
                    q[r] = i;
                    placeNQueens(q,r+1);
                }
            }
        }
    }
}
