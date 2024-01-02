import java.io.*;
import java.util.*;

public class BOJ18258 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        StringTokenizer st;
        while(n-->0){
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    Integer ite = q.peek();
                    if(ite == null) sb.append(-1).append('\n');
                    else sb.append(ite).append('\n');
                    break;
                case "back":
                    Integer it = q.peekLast();
                    if(it == null) sb.append(-1).append('\n');
                    else sb.append(it).append('\n');
                    break;
                case "empty":
                    if(q.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "size" :
                    sb.append(q.size()).append('\n');
                    break;
                case "pop":
                    Integer item = q.poll();
                    if(item == null){
                        sb.append(-1).append('\n');
                    }else sb.append(item).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
