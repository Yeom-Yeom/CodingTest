import java.util.*;
public class BOJ10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            if(n!=0){
                stack.push(n);
            }
            else stack.pop();
        }
        for(int x : stack){
            ans+=x;
        }
        System.out.println(ans);
    }
}
