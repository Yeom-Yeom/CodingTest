import java.util.*;
import java.io.*;
public class BOJ2374 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Long> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        long max = 0;
        long ans = 0;
        for(int i=0; i<n; i++){
            long x = Long.parseLong(br.readLine());
            max = Math.max(max, x);
            if(stack.isEmpty())
                stack.push(x);
            else{
                if(stack.peek() < x){
                    ans += x - stack.pop();
                    stack.push(x);
                }
                else if(stack.peek() > x){
                    stack.pop();
                    stack.add(x);
                }
            }
        }
        while(!stack.isEmpty()){
            long num = stack.pop();
            ans += max-num;
        }
        System.out.println(ans);
    }
}
