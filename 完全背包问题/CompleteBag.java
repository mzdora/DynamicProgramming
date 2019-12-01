public class CompleteBag{
    public static void main(String[] args) {
        //有 N 种物品和一个容量为 V 的背包，每种物品都有无限件可用。第 i 种物品的容积是 c[i]，价值是 w[i]。
        //求解使这些物品的费用总和不超过背包容量，且价值总和最大。
        int[] items_volume = {0, 2, 5, 3, 3, 1 ,5 ,2 ,4 ,7 ,1 };
        int[] items_cost =   {0, 3, 3, 6, 1, 1, 2, 2, 3, 4, 1 };
        int N = items_volume.length;
        int V = 8;
        int[][] dp = new int[N][V+1];
        
        /*
        这个问题非常类似于 01 背包问题，所不同的是每种物品有无限件。
        也就是从每 种物品的角度考虑，与它相关的策略已并非取或不取两种，
        而是有取 0 件、取 1 件、取 2 件„„等很多种。
        如果仍然按照解 01 背包时的思路，令 f[i][v]表示 前 i 种物品恰放入一个容量为 v 的背包的最大权值。
        仍然可以按照每种物品不同 的策略写出状态转移方程
        dp[i][v] = max(dp[i-1][v],dp[i-1][v-k*v[i]]+k*w[i])

        (复杂度贼尼玛高，O(ivk))
        :) 所以我们一般不写这么傻逼的代码。
        */
        for(int i=1;i<N;i++){
            for(int v=1;v<=V;v++){
                //一共能取nCount次
                int nCount = v / items_volume[i];  
                for(int k=0;k<=nCount;k++){
                    dp[i][v] = Math.max(dp[i-1][v],dp[i-1][v-k*items_volume[i]]+k*items_cost[i]);
                }
            }
        }
        System.out.println(dp[N-1][V]);
    }
}