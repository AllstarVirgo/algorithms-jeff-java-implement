package dp;

public class BestTimeToBuyAndSellStockWithCooldown {
    /**
     * 定义benefits[i] 为从i开始能盈利的最大值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] benefits = new int[prices.length];
        int last = prices.length-1;
        if(last==-1)return 0;
        benefits[last] = 0;
        for (int i = last-1; i >= 0; i--) {
            int maxProfit = benefits[i+1];
            for (int j = i+1; j <= last ; j++) {
                if(prices[j]>prices[i]){
                    int tempProfit = prices[j] - prices[i];
                    if((j+2)<=last){
                        tempProfit += benefits[j+2];
                    }
                    if(tempProfit>maxProfit)
                        maxProfit = tempProfit;
                }
            }
            benefits[i] = maxProfit;
        }
        int maxProfitFromAll = 0;
        for (int i = 0; i <= last; i++) {
            if(benefits[i]>maxProfitFromAll)
                maxProfitFromAll = benefits[i];
        }
        return maxProfitFromAll;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown bestTimeToBuyAndSellStockWithCooldown = new BestTimeToBuyAndSellStockWithCooldown();
        int[] demo = {2,1,4};
        int[] demo1 = {6,1,6,4,3,0,2};
        bestTimeToBuyAndSellStockWithCooldown.maxProfit(demo1);
    }
}
