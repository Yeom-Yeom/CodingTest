import java.util.*;
import java.io.*;
public class BOJ12100 {
    static int max = 0;
    static int n;
    static int[][] map;
    static int[][] temp;
    static int[] direct;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        direct = new int[5];
        StringTokenizer st;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(5,0);
        System.out.println(max);
    }

    public static void dfs(int end, int index){
        if(index==end) confirm();
        else{
            for(int i=0; i<4; i++){
                direct[index] = i;
                dfs(end,index+1);
            }
        }
    }

    public static void confirm(){
        temp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            temp[i] = map[i].clone();
        }
        for(int d=0; d<direct.length; d++){
            visit = new boolean[n+1][n+1];
            if(direct[d] == 0){ // up
                for(int i=1;i<=n; i++){
                    for(int j=1; j<=n; j++){
                        move(i,j,direct[d]);
                    }
                }
            }
            else if(direct[d] == 2) { // down
                for(int i=n; i>=1; i--){
                    for(int j=1;j<=n;j++){
                        move(i,j,direct[d]);
                    }
                }
            }
            else if(direct[d] == 1){ // right
                for(int i=n;i>=1; i--){
                    for(int j=1; j<=n; j++){
                        move(j,i,direct[d]);
                    }
                }
            }
            else{ // left
                for(int i=1; i<=n; i++){
                    for(int j=1; j<=n; j++){
                        move(j,i,direct[d]);
                    }
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n;j++){
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
    }

    static void move(int x, int y, int dir){
        if(temp[x][y] == 0) return;
        while(true){
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(nx<1 || ny <1 || nx > n || ny>n) return;
            if(visit[nx][ny]) return;
            if(temp[nx][ny] == temp[x][y]){
                visit[nx][ny] = true;
                temp[nx][ny] *=2;
                temp[x][y] = 0;
                return;
            }else if(temp[nx][ny] != 0) return;
            temp[nx][ny] = temp[x][y];
            temp[x][y] = 0;
            x = nx;
            y = ny;
        }
    }

}
