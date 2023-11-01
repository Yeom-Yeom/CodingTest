import java.util.*;
import java.io.*;
public class BOJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String s = br.readLine();
            int ans = 0;
            int score = 0;
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == 'O'){
                    score++;
                    ans+=score;
                }else{
                    score=0;
                }
            }
            System.out.println(ans);
        }
    }
}
