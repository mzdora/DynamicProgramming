public class bag01{
    public static void main(String[] args) {
        //有 N 件物品和一个容量为 V 的背包。第 i 件物品的容积是 c[i]，价值是 w[i]。 
        //求解背包最大价值总和。
        
        //dp[i][v] = Math.max(dp[i-1][v],dp[i-1][v-c[i]]+w[i]);
        /*
            他是存在这样一个表格:
            
            |____| i[0]| i[1]| i[2]| ...| i[N]|
            |v[0]|_____|_____|_____|____|_____|
            |v[0]|_____|_____|_____|____|_____|
            |... |_____|_____|_____|____|_____|
            |v[V]|_____|_____|_____|____|_____|

            i代表第i个物品 v代表容量
        */

        //假设我们有 10 件物品和一个容量为 8 的背包。第 i 件物品的容积是 items_volume[i]，价值是 items_cost[i]。 
        int[] items_volume = {0, 2, 5, 3, 3, 1 ,5 ,2 ,4 ,7 ,1 };
        int[] items_cost =   {0, 3, 3, 6, 1, 1, 2, 2, 3, 4, 2 };
        int N = items_volume.length;
        int V = 8;
        //dp是在当前条件的最高价值
        /*
        将前 i 件物品放入容量为 v 的背包中 这个子问题
        若只考虑第 i 件物品的策略（放或不放)
        那么就可以转化为一个只牵扯前 i-1 件物品的问题
        如果不放第 i 件物品
        那么问题就转化为 “前 i-1 件物品放入容量为 v 的背包中”
        价值为 dp[i-1][v]
        如果放第 i 件物品
        那么问题就 转化为“前 i-1 件物品放入剩下的容量为 v-c[i] 的背包中”
        此时能获得的最大价值就是 dp[i-1][v-c[i]] 再加上通过放入第 i 件物品获得的价值 w[i]
        */
        int[][] dp = new int[N][V+1];
        
        for(int i=1;i<N;i++){
            for(int v=1;v<=V;v++){
                if(v-items_volume[i] < 0){
                    dp[i][v] = dp[i-1][v];
                }else{
                    dp[i][v] = Math.max(dp[i-1][v],dp[i-1][v-items_volume[i]]+items_cost[i]);
                }
            }
        }
        System.out.println(dp[N-1][V]);
    }
}