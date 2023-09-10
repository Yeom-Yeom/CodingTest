import java.io.*;
import java.util.*;
public class BOJ2346 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int[] arr=  {i+1, Integer.parseInt(st.nextToken())};
            deque.add(arr);
        }
        while(deque.size() > 1){
            int[] arr = deque.pollFirst();
            sb.append(arr[0]).append(" ");
            int m = arr[1];
            if(m>0){
                for(int j=1; j<m;j++){
                    deque.offerLast(deque.pollFirst());
                }
            }else if(m<0){
                for(int j=m; j!=0; j++){
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        sb.append(deque.poll()[0]);
        bw.write(sb+"\n");
        bw.flush();
        bw.close();
    }
}
