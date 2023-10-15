import java.util.*;
public class BOJ2178 {
    public static int n,m;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String s = sc.next();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(arr[n-1][m-1]);
    }
    public static void bfs(int x, int y){
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[] {x,y});
        while(!q.isEmpty()){
            int now[] = q.poll();
            int nx = now[0];
            int ny = now[1];

            for(int i=0 ;i<4; i++){
                int cx = nx+dx[i];
                int cy = ny+dy[i];
                if(cx>=0&& cy>=0 && cx<n && cy<m){
                    if(!visited[cx][cy] && arr[cx][cy] == 1){
                        q.add(new int[] {cx,cy});
                        arr[cx][cy ] = arr[nx][ny]+1;
                        visited[cx][cy] = true;
                    }
                }
            }
        }
    }

}
