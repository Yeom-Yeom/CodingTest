import java.util.*;
public class BOJ1012 {
    static int t,m,n,k;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int cnt;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for(int i=0; i<t; i++){
            cnt = 0;
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            arr = new int[m][n];
            visited = new boolean[m][n];
            for(int j=0; j<k; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }
            for(int a=0; a<m; a++){
                for(int b=0; b<n; b++){
                    if(arr[a][b] == 1 && !visited[a][b]){
                        dfs(a,b);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0 ;i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<m && ny<n){
                if(arr[nx][ny] ==1 && !visited[nx][ny])
                    dfs(nx,ny);
            }
        }
    }
}
