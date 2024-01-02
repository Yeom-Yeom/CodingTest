import java.util.*;
import java.io.*;
public class BOJ10816 {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       StringBuilder sb = new StringBuilder();
       HashMap<Integer, Integer> hash = new HashMap<Integer,Integer>();

       StringTokenizer st = new StringTokenizer(br.readLine());
       for(int i=0; i<n; i++){
           int input = Integer.parseInt(st.nextToken());
           if(hash.get(input) == null) hash.put(input, 1);
           else hash.put(input, hash.get(input)+1);
       }
       int m = Integer.parseInt(br.readLine());
       st = new StringTokenizer(br.readLine());
       for(int i=0; i<m; i++){
           int input = Integer.parseInt(st.nextToken());
           if(hash.get(input)==null) sb.append(0).append(" ");
           else sb.append(hash.get(input)).append(" ");
       }
       System.out.println(sb);
    }
}
