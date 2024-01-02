import java.util.*;
import java.io.*;
public class BOJ9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
           Stack<Integer> stack = new Stack<>();
           String s = br.readLine();
           for(int j=0 ;j<s.length(); j++){
               if(s.charAt(j) == '(')
                   stack.push(1);
               else{
                   if(stack.size() == 0){
                       stack.push(1);
                       break;
                   }else stack.pop();
               }
           }
           if(stack.isEmpty()) System.out.println("YES");
           else System.out.println("NO");
        }
    }
}
