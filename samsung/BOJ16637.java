package samsung;

import java.io.*;
import java.util.ArrayList;

public class BOJ16637 {
    static int n;
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> num = new ArrayList<>();
    static ArrayList<Character> op = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n  = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i=0; i<n; i++){
            if(i%2==0){
                num.add(s.charAt(i)-'0');
            }
            else op.add(s.charAt(i));
        }
        int start = num.get(0);
        dfs(0,start);
        System.out.println(max);
    }
    public static void dfs(int now, int sum){
        if(now>=op.size()){
            max = Math.max(max,sum);
            return;
        }
        int one = cal(now,sum,num.get(now+1));
        dfs(now+1, one);
        if(now+1 < op.size()){
            int two = cal(now+1, num.get(now+1), num.get(now+2));
            int res = cal(now,sum,two);
            dfs(now+2,res);
        }
    }
    public static int cal(int op_idx, int a, int b){
        switch (op.get(op_idx)){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
        }
        return 1;
    }
}
