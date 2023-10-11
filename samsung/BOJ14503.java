package samsung;

import java.util.*;
import java.io.*;
public class BOJ14503 {
    static int n,m,r,c,d;
    static int cnt = 1;
    static int[][] room;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {-1,0,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r,c,d);
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int dir){
        room[x][y] = -1;
        for(int i=0; i<4; i++){
            dir = (dir+3)%4;
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(nx >=0 && ny>=0 && nx<n && ny<m && room[nx][ny] == 0){
                cnt++;
                dfs(nx,ny,dir);
                return;
            }
        }
        int b = (dir+2)%4;
        int bx = x+dx[b];
        int by = y+dy[b];
        if(bx>=0 && by >=0 && bx<n && by<m && room[bx][by]!=1){
            dfs(bx,by,dir);
        }
    }

}
