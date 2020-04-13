package pointer;

public class ContinuesArray {
    private static int getMaxContinuesArray(int[] array){
        int n = array.length;
        int[] dp = new int[n];
        if(n==0)return 0;
        dp[n-1] = 1;
        for (int i = n-2; i >=0 ; i--) {
            int maxContinus = 1;
            for (int j = i+1; j < n; j++) {
                if(array[j]-1==array[i]){
                    //从j开始算起的连续最大值
                    int temp = 1 + dp[j];
                    if(temp>maxContinus)
                        maxContinus = temp;
                }
                dp[i] = maxContinus;
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i]>res)
                res = dp[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] array = {6,5,2,7,3,8,9};
        System.out.println(getMaxContinuesArray(array));
    }
}
