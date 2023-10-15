import java.util.*;
import java.io.*;
public class BOJ16926 {
    static int n,m,r;
    static int min;
    static int[][] map;
    static int[] dx=  {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Math.min(n,m);
        for(int i=1; i<=r; i++){
            rotate();
        }
        print();
    }

    public static void rotate(){
        for(int t=0; t<min/2; t++){
            int x = t;
            int y = t;
            int tmp = map[x][y];
            int idx = 0;
            while(idx<4){
                int nx = x+dx[idx];
                int ny = y+dy[idx];
                if(nx<n-t && ny<m-t && nx>=t && ny>=t){
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                }
                else idx++;
            }
            map[t+1][t] = tmp;
        }
    }
    public static void print(){
        for(int i=0; i<n ;i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
