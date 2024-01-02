import java.util.*;
import java.io.*;

public class SWEA10965 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            int n = Integer.parseInt(br.readLine());
            int res = find(n);
            System.out.println("#"+tc+" "+res);
        }
    }
    private static int find(int n){
        int small = 1;
        for(int i=2; i*i<=n; i++){
            int cnt = 0;
            while(n%i==0){
                n/=i;
                cnt++;
            }
            if(cnt%2!=0){
                small*=i;
            }
        }
        if(n>1){
            small *= n;
        }
        return small;
    }
}
