import java.io.*;
import java.util.*;
public class BOJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<s.length(); j++){
                sb.append(Character.toString(s.charAt(j)).repeat(n));
            }
            System.out.println(sb);
        }
    }
}
