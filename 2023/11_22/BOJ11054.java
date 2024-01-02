import java.util.Scanner;

public class BOJ11054 {
    static Integer[] r_dp;
    static Integer[] l_dp;
    static int[] seq;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        r_dp = new Integer[n];
        l_dp = new Integer[n];
        seq = new int[n];

        for(int i=0; i<n; i++){
            seq[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            LIS(i);
            LDS(i);
        }
        int max = -1;
        for(int i=0; i<n; i++){
            max = Math.max(r_dp[i]+l_dp[i], max);
        }
        System.out.println(max-1);

    }
    static int LIS(int n){
        if(r_dp[n] == null){
            r_dp[n] = 1;
            for(int i=n-1; i>=0; i--){
                if(seq[i]<seq[n]){
                    r_dp[n] = Math.max(r_dp[n], LIS(i)+1);
                }
            }
        }
        return r_dp[n];
    }
    static int LDS(int n){
        if(l_dp[n] == null){
            l_dp[n] = 1;
            for(int i=n+1; i<l_dp.length; i++){
                if(seq[i]<seq[n]){
                    l_dp[n] = Math.max(l_dp[n], LDS(i)+1);
                }
            }
        }
        return l_dp[n];
    }
}
