package tree;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] uniqueTreeNums = new int[n+1];
        uniqueTreeNums[1] = 1;
        uniqueTreeNums[0] = 1;
        for (int i = 2; i < n + 1; i++) {
            int total = 0;
            for (int j = 1; j <=i ; j++) {
                total += (uniqueTreeNums[i-j]*uniqueTreeNums[j-1]);
            }
            uniqueTreeNums[i] = total;
        }
        return uniqueTreeNums[n];
    }
}
