import java.util.*;
import java.io.*;
class Tomato{
    int x;
    int y;

    public Tomato(int x, int y){
        this.x =x;
        this.y= y;
    }
}
public class BOJ7576 {
    static int n,m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static Queue<Tomato> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.add(new Tomato(i,j));
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        while(!q.isEmpty()){
            Tomato t = q.poll();
            int x = t.x;
            int y = t.y;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    if(map[nx][ny] == 0){
                        map[nx][ny] = map[x][y]+1;
                        q.add(new Tomato(nx,ny));
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        if(checkZero()){
            return -1;
        }else{
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(max<map[i][j]){
                        max = map[i][j];
                    }
                }
            }
        }
        return max-1;
    }
    private static boolean checkZero(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
}
