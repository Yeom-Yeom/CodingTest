import java.util.*;
public class BOJ17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int[] seq = new int[n];
        for(int i=0; i<n; i++){
            seq[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && seq[stack.peek()] < seq[i]){
                seq[stack.pop()] = seq[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(seq[i]).append(' ');
        }
        System.out.println(sb);
    }
}
