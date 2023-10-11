package samsung;

import java.util.*;
import java.io.*;
public class BOJ14501 {
    static int[] dp;
    static int[] t;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        t= new int[n];
        p= new int[n];
        dp = new int[n+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n ;i++){
            if(i+t[i] <=n){
                dp[i+t[i]] = Math.max(dp[i+t[i]],dp[i]+p[i]);
            }
            dp[i+1] = Math.max(dp[i+1],dp[i]);
        }
        System.out.println(dp[n]);
    }

}
