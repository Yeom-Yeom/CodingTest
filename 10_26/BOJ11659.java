import java.util.*;
import java.io.*;
public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[0] = 0;
            arr[i] = arr[i-1]+ Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(arr[end]-arr[start-1]).append("\n");
        }
        System.out.println(sb);
    }
}
