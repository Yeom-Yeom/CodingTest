import java.util.*;
import java.io.*;
public class BOJ14500 {
    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visit;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visit[i][j] = true;
                solve(i,j,arr[i][j],1);
                visit[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static void solve(int x, int y, int sum, int count){
        // 테트로미노 완성 시 수들의 합 계산
        if(count == 4){
            max = Math.max(max,sum);
            return;
        }
        // 상하좌우 탐색
        for(int i=0; i<4; i++){
            int cx = x+dx[i];
            int cy = y+dy[i];
            // 범위를 벗어나면 예외 처리
            if(cx < 0 || cy < 0 || cx>=n || cy>=m){
                continue;
            }
            // 아직 방문하지 않은 곳이라면
            if(!visit[cx][cy]){
                // 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 한번 더 탐색 진행
                if(count == 2){
                    visit[cx][cy] = true;
                    solve(x,y,sum+arr[cx][cy], count+1);
                    visit[cx][cy] = false;
                }
                visit[cx][cy] = true;
                solve(cx,cy,sum+arr[cx][cy],count+1);
                visit[cx][cy] = false;
            }
        }
    }
}
