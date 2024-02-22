import java.util.*;
import java.io.*;
public class BOJ2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> flowers = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[] nums = new int[2];
            nums[0] = a*100+b;
            nums[1] = c*100+d;
            flowers.add(nums);
        }
        flowers.sort((a,b)->Integer.compare(a[0],b[0]));
        int st = 301;
        int idx = 0;
        int ans = 0;
        while (st < 1201) {
            int liveDays = 0;
            while(idx<n && flowers.get(idx)[0] <= st){
                liveDays = Math.max(liveDays, flowers.get(idx)[1]);
                ++idx;
            }
            if(liveDays==0){
                ans = 0;
                break;
            }
            st = liveDays;
            ans++;
        }
        System.out.println(ans);
    }
}

/**
 * 문제 해석
 * 현 시점에서 피어있는 꽃들 중 가장 오래 피어있는 꽃을 선택하면
 * 가장 적은 수의 꽃을 선택할 수 있다.
 *
 **/