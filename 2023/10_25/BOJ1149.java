import java.util.Scanner;

public class BOJ1149 {
    static int n;
    static int[][] cost;
    static int[][] dp;
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][3];
        dp = new int[n][3];

        for(int i=0; i<n; i++){
            cost[i][Red] = sc.nextInt();
            cost[i][Green] = sc.nextInt();
            cost[i][Blue] = sc.nextInt();
        }
        dp[0][Red] = cost[0][Red];
        dp[0][Green] = cost[0][Green];
        dp[0][Blue] = cost[0][Blue];

        System.out.println(Math.min(Paint_cost(n-1,Red),Math.min(Paint_cost(n-1,Green),Paint_cost(n-1,Blue))));
    }
    public static int Paint_cost(int n, int color){
        if(dp[n][color] == 0){
            if(color == Red){
                dp[n][Red] = Math.min(Paint_cost(n-1,Green), Paint_cost(n-1,Blue))+cost[n][Red];
            }
            else if(color == Green){
                dp[n][Green] = Math.min(Paint_cost(n-1,Red),Paint_cost(n-1,Blue))+cost[n][Green];
            }
            else dp[n][Blue] = Math.min(Paint_cost(n-1,Red),Paint_cost(n-1,Green))+cost[n][Blue];
        }

        return dp[n][color];
    }
}
