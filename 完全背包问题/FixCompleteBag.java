public class FixCompleteBag{
    public static void main(String[] args) {
        int[] items_volume = {0, 2, 5, 3, 3, 1 ,5 ,2 ,4 ,7 ,1 };
        int[] items_cost =   {0, 3, 3, 6, 1, 1, 2, 2, 3, 4, 1 };
        int N = items_volume.length;
        int V = 8;
        int[][] dp = new int[N][V+1];

        /*
        这个伪代码与 01bag 的伪代码只有 v 的循环次序不同而已
        为什么这样一改就可行呢？
        首先想想为什么 01bag 中要按照 v=V..0 的逆序来循环
        这是因为要保证第 i 次循环中的状态 f[i][v]是由状态 f[i-1][v-c[i]]递推而来
        换句话说，这正是为了保证每件物品只选一次
        保证在考虑“选入第 i 件物品”这件策略时
        依据的是一个绝无已经选入第 i 件物品的子结果 f[i-1][v-c[i]]
        而现在完全背包的特点恰是每种物品可选无限件
        所以在考虑“加选一件第 i 种物品”这种策略时
        却正需要一个可能已选入第 i 种物品的子结果 f[i][v-c[i]]
        所以就可以并且必须采用 v=0..V 的顺序循环
        这就是这个简单的程序为何成立的道理
        */
        
        for(int i=1;i<N;i++){
            //v := 0..V可以取多次。
            for(int v=0;v<=V;v++){
                if(v-items_volume[i]<0){
                    dp[i][v] = dp[i-1][v];
                }else{
                    //由于可以无限取，所以后面那个dp[i-1]...还是dp[i]
                    dp[i][v] = Math.max(dp[i-1][v],dp[i][v-items_volume[i]]+items_cost[i]);
                }
            }
        }
        System.out.println(dp[N-1][V]);
    }
}