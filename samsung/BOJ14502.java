package samsung;

import java.util.*;
import java.io.*;
public class BOJ14502 {
    static int n;
    static int m;
    static int[][] map;
    // 상 하 좌 우
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static  int maxSafety = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(maxSafety);

    }
    static void dfs(int wallCnt){
        if(wallCnt == 3){
            bfs();
            return;
        }
        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wallCnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] ==2)
                    q.add(new Node(i,j));
            }
        }

        int copyMap[][] = new int[n][m];
        for(int i=0; i<n; i++){
            copyMap[i] = map[i].clone();
        }

        // bfs 탐색 시작
        while(!q.isEmpty()){
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];

                // 연구소 범위 밖이 아니고 빈칸일 경우에만 바이러스를 퍼트림
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(copyMap[nx][ny] == 0){
                        q.add(new Node(nx,ny));
                        copyMap[nx][ny] = 2;
                    }
                }
            }
        }

        // SafeZone 확인
        funcSafeZone(copyMap);
    }
    private static void funcSafeZone(int[][] copyMap){
        int safeZone = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyMap[i][j] == 0){
                    safeZone++;
                }
            }
        }
        if(maxSafety < safeZone){
            maxSafety = safeZone;
        }
    }

    // Queue에 좌표값 x,y를 넣기 위함
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
