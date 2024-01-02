import java.util.*;
public class BOJ2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.offer(i);
        }
        while(q.size()!=1){
            q.pollFirst();
            q.offer(q.peekFirst());
            q.pollFirst();
        }
        System.out.println(q.peek());
    }
}
