import java.util.*;
public class BOJ2468 {
    static int n;
    static int[][] arr;
    static int[][] tmp;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1][n+1];
        tmp = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] > max)
                    max = arr[i][j];
            }
        }
        int val = 0;
        for(int x=0; x<max+1; x++){
            visited = new boolean[n+1][n+1];
            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j] && arr[i][j] > x){
                        cnt+=dfs(i,j,x);
                    }
                }
            }
            val = Math.max(val,cnt);
        }
        System.out.println(val);
    }
    static int dfs(int x, int y, int height){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<n){
                if(!visited[nx][ny] && arr[nx][ny] > height)
                    dfs(nx,ny,height);
            }
        }
        return 1;
    }
}
