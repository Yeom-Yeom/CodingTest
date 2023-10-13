import java.util.*;
public class BOJ4963 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1,1,1,-1,-1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int w,h;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true){
            int cnt =0;
            w = sc.nextInt();
            h = sc.nextInt();
            if(w==0 && h==0) break;
            map = new int[h+1][w+1];
            visited = new boolean[h+1][w+1];
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        cnt++;
                        dfs(i,j);
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<h && ny<w){
                if(map[nx][ny] == 1 && !visited[nx][ny])
                    dfs(nx,ny);
            }
        }
    }
}
