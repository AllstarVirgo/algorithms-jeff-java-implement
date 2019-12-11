package dp;

public class PerfectSquares {
    /**
     * 要先下给目标下一个定义，就是定义我们要求解什么。
     * 这里我们定义：ln(n)为平方数的和为n时，需要的最少的平方数
     * 然后我们需要给出关系式
     *
     * ln(n) = ln(n-array(k-1)) + 1   ((k-1)>=0)
     *
     * array[k]表示平方数列表，但最大值不超过n
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] squareArray = new int[n+1];
        squareArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            int squareN = (int) Math.floor(Math.sqrt(i));
            int count = Integer.MAX_VALUE;
            for (int j = squareN; j >=1 ; j--) {
                int temp = 1 + squareArray[i-j*j];
                if(temp<count)
                    count = temp;
            }
            squareArray[i] = count;
        }
        return squareArray[n];
    }

    public int numSquaresBetter(int n) {
        int[] squareArray = new int[n+1];
        squareArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            int count = Integer.MAX_VALUE;
            int j =1,rest;
            /*用 i-j*j 可以替代平方表的作用,节省求平方数需要的时间*/
            while ((rest = (i-j*j))>=0){
                int temp = 1 + squareArray[rest];
                if(temp<count)
                    count = temp;
                j++;
            }
            squareArray[i] = count;
        }
        return squareArray[n];
    }
}
