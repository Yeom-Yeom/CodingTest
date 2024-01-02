import java.util.*;
import java.io.*;
public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0 && pq.isEmpty()){
                System.out.println(0);
            }else if(x==0){
                System.out.println(pq.peek());
                pq.poll();
            }else{
                pq.add(x);
            }
        }
    }
}
