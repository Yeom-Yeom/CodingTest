import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SWEA10912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<=T; tc++){
            sb.append("#"+tc+" ");
            int[] alpha = new int[26];
            String s = br.readLine();
            for(int i=0; i<s.length(); i++){
                int idx = s.charAt(i)-'a';
                alpha[idx]++;
            }
            boolean flag = false;
            for(int i=0; i<26; i++){
                if(alpha[i]%2!=0){
                    flag=true;
                    sb.append((char)('a'+i));
                }
            }
            if(!flag) sb.append("Good");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
