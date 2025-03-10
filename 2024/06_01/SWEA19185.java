import java.util.*;
public class SWEA19185 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] s = new String[n+1];
            String[] t = new String[m+1];
            for(int i=1; i<=n; i++){
                s[i] = sc.next();
            }
            for(int i=1; i<=m; i++){
                t[i] = sc.next();
            }
            int Q = sc.nextInt();
            List<String> ans = new ArrayList<>();
            s[0] = s[n];
            t[0] = t[m];
            for(int i=0; i<Q; i++){
                int y = sc.nextInt();
                if(y<n && y<m){
                    ans.add(s[y]+t[y]);
                }
                else {
                    ans.add(s[y % n] + t[y % m]);
                }
            }
            System.out.print("#"+tc+" ");
            for(int i=0; i<ans.size(); i++){
                System.out.print(ans.get(i)+" " );
            }
            System.out.println();
        }
    }
}
