import java.util.*;
import java.io.*;
public class BOJ13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long cnt = 0;
        cnt+=n;
        for (int i = 0; i < n; i++) {
            a[i] -= b;
            if(a[i]<=0) continue;
            cnt+= a[i]/c;
            if(a[i]%c != 0)
                cnt++;
        }

        System.out.println(cnt);
    }
}
