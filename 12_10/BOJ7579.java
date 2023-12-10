import java.util.*;
public class BOJ7579 {
    static int n,m;
    static long[] mem;
    static int[] cost;
    static int ans = 20000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        mem = new long[n+1];
        cost = new int[n+1];
        int col=0;
        for(int i=1; i<=n; i++){
            mem[i] = sc.nextLong();
        }
        for(int i=1; i<=n; i++){
            cost[i] = sc.nextInt();
            col += cost[i];
        }
        long[][] dp = new long[n+1][col+1];
        for(int i=1; i<=n; i++){
            for(int j=0; j<=col; j++){
                if(j-cost[i] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]]+mem[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                if(dp[i][j] >= m){
                    ans = Math.min(ans, j);
                }
            }
        }
        System.out.println(ans);
    }
}
