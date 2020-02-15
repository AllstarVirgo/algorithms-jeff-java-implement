package leetcode;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    /**
     * 二分搜索法（range搜索）
     * lo           small  mid large           hi
     * ^                                       ^
     * |                                       |
     * |                                       |
     * |                                       |
     * |                                       |
     * |                                       |
     *
     * mid 不一定是矩阵中的元素，因此需要记录 small和 large，他们
     * 分别是 仅小于 和 仅大于 mid的矩阵中的元素
     *      * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int j = n - 1, count = 0, small = lo, large = hi;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    large = Math.min(large, matrix[i][j]);
                    j--;
                }
                if (j >= 0)
                    small = Math.max(small, matrix[i][j]);
                count += (j + 1);
            }
            if (count < k) lo = large;

            else if (count == k) return small;

            else hi = small;
        }
        return lo;
    }

    /**
     * Priority queue
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(new Tuple(0,i,matrix[0][i]));
        }

        for (int i = 0; i < k; i++) {
            Tuple smallest = priorityQueue.poll();
            if(smallest.x == n-1)continue;
            priorityQueue.offer(new Tuple(smallest.x+1,smallest.y,matrix[smallest.x+1][smallest.y]));
        }
        return priorityQueue.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {
                        1, 5, 9
                },
                {
                        10, 11, 13
                },
                {
                        12, 13, 15
                }
        };
        KthSmallestElementInASortedMatrix kthSmallestElementInABST = new KthSmallestElementInASortedMatrix();
        kthSmallestElementInABST.kthSmallest(matrix, 8);
    }
}
