import java.util.*;
import java.io.*;
public class BOJ2629 {
    static int n;
    static int[] arr;
    static boolean[][] res;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st =  new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        res = new boolean[n+1][40001];
        backtracking(0,0);
        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<t; i++){
            int k = Integer.parseInt(st.nextToken());
            if(res[n][k])
                sb.append("Y ");
            else sb.append("N ");
        }
        System.out.println(sb);
    }
    public static void backtracking(int cnt, int sum){
        if(sum>500*30 || res[cnt][sum]) return;
        res[cnt][sum] = true;
        if(cnt==n) return;
        backtracking(cnt+1, sum+arr[cnt]);
        backtracking(cnt+1, sum);
        backtracking(cnt+1, Math.abs(sum-arr[cnt]));
    }
}
