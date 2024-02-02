import java.util.*;
import java.io.*;
public class ObstacleAwarenessProgram {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    static int ans = 0;
    static int sum = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n+1][n+1];
        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            char[] tmp = data.toCharArray();
            for(int j=0 ;j<data.length(); j++){
                board[i][j+1] = Integer.parseInt(String.valueOf(tmp[j]));
            }
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(board[i][j] == 1){
                    ans++;
                    board[i][j] = 0;
                    sum = 1;
                    dfs(i,j,board);
                    list.add(sum);
                }
            }
        }
        System.out.println(ans);
        list.sort(Comparator.comparingInt(o->o));
        list.stream().forEach(a->System.out.println(a));
    }
    public static void dfs(int x, int y, int[][] board){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=1 && nx<n+1 && ny>=1 && ny<n+1 && board[nx][ny] == 1){
                board[nx][ny] = 0;
                sum++;
                dfs(nx,ny,board);
            }
        }
    }
}

/**
 * 문제 해석
 * (0,0)부터 블럭에 적힌 번호를 확인한다.
 * 0이 적혀있다면 장애물이 아닌 곳이고, 1이 적혀있다면 장애물인 곳이다.
 * 1이 적힌 곳이라면 거기서 상,하,좌,우로 이동했을 때에도 1이 적혀있는지, 0이 적혀있는지 확인한다.
 * 장애물을 지났다면 지난 장애물은 다시 지나지 않도록 0으로 변경해준다.
 **/
