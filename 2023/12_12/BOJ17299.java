import java.util.*;
import java.io.*;

public class BOJ17299 {
    static final int MAX = 1_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[MAX];
        int[] idx = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            idx[i] = Integer.parseInt(st.nextToken());
            cnt[idx[i]]++;
        }
        for(int i=0; i<n; i++){
            while(!stack.empty() && cnt[idx[i]] > cnt[idx[stack.peek()]]){
                ans[stack.pop()] = idx[i];
            }
            stack.push(i);
        }
        while(!stack.empty()){
            ans[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(ans[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
