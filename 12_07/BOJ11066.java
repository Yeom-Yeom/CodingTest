import java.util.*;
import java.io.*;
public class BOJ11066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int files[];
            int k = sc.nextInt();
            files = new int[k+1];
            int[][] dp = new int[k+1][k+1];

            files[1] = sc.nextInt();
            for(int j=2; j<=k; j++){
                int tmp = sc.nextInt();
                files[j] = tmp+files[j-1];
            }

            for(int gap=1; gap<k; gap++){
                for(int start=1; start+gap<=k; start++){
                    int end = start+gap;
                    dp[start][end] = Integer.MAX_VALUE;
                    for(int mid = start; mid<end; mid++){
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid]+dp[mid+1][end]+files[end]-files[start-1]);
                    }
                }
            }
            System.out.println(dp[1][k]);
        }
    }
}
