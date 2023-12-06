import java.util.*;
import java.io.*;
public class BOJ11286 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)){
                    return Math.abs(o1) - Math.abs(o2);
                }else if(Math.abs(o1) == Math.abs(o2)){
                    return o1-o2;
                }else{
                    return -1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()) sb.append("0").append("\n");
                else sb.append(pq.poll()).append("\n");
            }else{
                pq.offer(x);
            }
        }
        System.out.println(sb);

    }
}
