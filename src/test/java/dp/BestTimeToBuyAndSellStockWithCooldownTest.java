package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockWithCooldownTest {

    @Test
    public void test(){
        BestTimeToBuyAndSellStockWithCooldown bestTimeToBuyAndSellStockWithCooldown = new BestTimeToBuyAndSellStockWithCooldown();
        int[] demo = {2,1,4};
        bestTimeToBuyAndSellStockWithCooldown.maxProfit(demo);
    }
}