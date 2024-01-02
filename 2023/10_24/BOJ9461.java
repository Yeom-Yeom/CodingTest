import java.util.Scanner;

public class BOJ9461 {
    static Long[] dp = new Long[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        dp[0] = 0L;
        dp[1] = dp[2] = dp[3] = 1L;
        while(t-->0){
            int n = sc.nextInt();
            System.out.println(padovan(n));
        }
    }
    public static long padovan(int n){
        if(dp[n] == null){
            dp[n] = padovan(n-3)+padovan(n-2);
        }
        return dp[n];
    }
}
