import java.util.*;

//787. K 站中转内最便宜的航班
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>>  prices = new HashMap<>();
        for(int[] f : flights){
            if(!prices.containsKey(f[0])){
                prices.put(f[0], new HashMap<>());
            }
            prices.get(f[0]).put(f[1],f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a,b) ->  a[0] - b[0]);
        pq.add(new int[]{0, src, K + 1});

        while (!pq.isEmpty()){
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if(city == dst) return price;
            if(stops > 0){
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for(int a : adj.keySet()){
                    pq.add(new int[]{price + adj.get(a), a, stops - 1});
                }
            }
        }
        return  -1;
    }


    /**
     动态规划解法, dp[i][k]表示经过k个中转站后到达站i的最低费用
     初始除了dp[src][0]~dp[src][k]之外所有的元素置为无穷大inf
     则状态方程为: 对于所有目标地位i的航班(flight[1] = i)
     只要dp[flight[0]][k-1] != inf就更新dp[i][k]
     dp[i][k] = Math.min(dp[i][k], dp[flight[0]][k-1])
     **/
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[n][K+2];
        for(int i = 0; i < n; ++i) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int k = 0; k <= K+1; ++k) dp[src][k] = 0;
        for(int k = 1; k <= K+1; ++k) {
            for(int[] flight : flights) {
                if(dp[flight[0]][k-1] != Integer.MAX_VALUE)
                    dp[flight[1]][k] = Math.min(dp[flight[1]][k], dp[flight[0]][k-1] + flight[2]);
            }
        }
        return dp[dst][K+1] == Integer.MAX_VALUE ? -1 : dp[dst][K+1];
    }
}
