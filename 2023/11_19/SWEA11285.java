import java.io.*;
import java.util.*;
public class SWEA11285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int x = Math.abs(Integer.parseInt(st.nextToken()));
                int y = Math.abs(Integer.parseInt(st.nextToken()));
                double dist = Math.sqrt(x*x+ y*y);
                if(dist == 0) ans+=10;
                else{
                    for(int j=1; j<=10; j++){
                        if(20*(11-j)>= dist && 20*(10-j)<dist){
                            ans+=j;
                            break;
                        }
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}
