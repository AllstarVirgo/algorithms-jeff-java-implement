package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }

        int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : list) {
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }

        return res;
    }
}
