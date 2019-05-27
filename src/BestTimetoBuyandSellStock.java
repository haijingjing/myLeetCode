//121 买卖股票的最好时机
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n ; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;

    }
}
