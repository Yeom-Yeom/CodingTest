import java.util.*;
import java.io.*;
public class BOJ1520 {
    public static int n,m;
    public static int[][] map;
    public static int[][] dp;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(1,1));
    }
    public static int dfs(int x, int y){
        if(x==n && y==m){
            return 1;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        else{
            dp[x][y] = 0;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=1 && ny>=1 && nx<=n && ny<=m){
                    if(map[x][y] > map[nx][ny]){
                        dp[x][y] +=dfs(nx,ny);
                    }
                }
            }
        }
        return dp[x][y];
    }
}
