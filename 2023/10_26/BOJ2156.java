import java.util.Scanner;

public class BOJ2156 {
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new Integer[n+1];
        arr = new int[n+1];

        for(int i=1; i<n+1; i++){
            arr[i] = sc.nextInt();
        }
        dp[0] = 0;
        dp[1] = arr[1];

        if(n>1){
            dp[2] = arr[1]+arr[2];
        }
        System.out.println(recur(n));
    }
    public static int recur(int n){
        if(dp[n] == null){
            dp[n] = Math.max(Math.max(recur(n-2),recur(n-3)+arr[n-1])+ arr[n], recur(n-1));
        }
        return dp[n];
    }
}
