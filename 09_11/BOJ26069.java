import java.util.*;
import java.io.*;

public class BOJ26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String userA, userB;
        HashSet<String> enterUser = new HashSet<>();
        enterUser.add("ChongChong");

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            userA = st.nextToken();
            userB = st.nextToken();

            if(enterUser.contains(userA) || enterUser.contains(userB)){
                enterUser.add(userA);
                enterUser.add(userB);
            }
        }
        br.close();
        bw.write(enterUser.size()+"\n");
        bw.flush();
        bw.close();
    }
}
