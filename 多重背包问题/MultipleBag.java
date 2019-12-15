public class MultipleBag{
    public static void main(String[] args) {
        //有 N 种物品和一个容量为 V 的背包。
        //第 i 种物品最多有 n[i] 件可用，每件容积是 c[i]，价值是 w[i]。
        //求解将哪些物品装入背包可使这些物品的容积总和不超过背包容量，且价值总和最大。 

        int[] items_volume = {0, 2, 5, 3, 3, 1 ,5 ,2 ,4 ,7 ,1 };
        int[] items_cost =   {0, 3, 3, 6, 1, 1, 2, 2, 3, 4, 1 };
        int[] n = {0,1,2,3,3,3,3,3,2,2,2};
        int N = items_volume.length;
        int V = 8;
        int[][] dp = new int[N][V+1];
        
        /*
        这个问题非常类似于 完全背包问题，所不同的是每种物品有有限件。
        那么我们按照完全背包的样子来写出它的状态转移方程
        dp[i][v] = max(dp[i-1][v],dp[i-1][v-k*v[i]]+k*w[i])
        而 K 不再是背包能取的最大个数了，而是既定的 0..n[i]

        (复杂度贼尼玛高，O(ivk))
        :) 但是我们不得不写这种代码
        */
        for(int i=1;i<N;i++){
            for(int v=1;v<=V;v++){
                //一共能取k次,K是遍历每一个物品能取的最大个数，
                //但是k和当前物体的容积乘积不能大于当前的背包容积
                for(int k=0;k<=n[i] && k*items_volume[i]<=v;k++){
                    dp[i][v] = Math.max(dp[i-1][v],dp[i-1][v-k*items_volume[i]]+k*items_cost[i]);
                }
            }
        }
        System.out.println(dp[N-1][V]);
    }
}