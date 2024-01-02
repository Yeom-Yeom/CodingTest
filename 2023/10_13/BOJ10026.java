import java.util.*;
import java.io.*;
public class BOJ10026 {
    static int n;
    static char[][] arr;
    static boolean[][] visited;
    static int cnt, cnt_rg;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[n+1][n+1];
        visited = new boolean[n+1][n+1];
        for(int i=0; i<n; i++){
            String s = sc.next();
            for(int j=0; j<n; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 'G')
                    arr[i][j] = 'R';
            }
        }
        visited = new boolean[n+1][n+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]) {
                    dfs(i, j);
                    cnt_rg++;
                }
            }
        }
        System.out.println(cnt+" "+cnt_rg);
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        char tmp_char = arr[x][y];
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<n){
                if(arr[nx][ny] == tmp_char && !visited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
}
