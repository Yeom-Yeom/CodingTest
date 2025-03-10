import java.util.*;
import java.io.*;
public class SFTR_FilialPietyTogether {
    static class Point{
        int x, y, time;
        Point(int y, int x, int time){
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] startX = new int[m];
        int[] startY = new int[m];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            startY[i] = Integer.parseInt(st.nextToken())-1;
            startX[i] = Integer.parseInt(st.nextToken())-1;
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][][] visited = new boolean[m][n][n];
        int[] maxHarvest = new int[m];

        for(int i=0; i<m; i++){
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(startY[i],startX[i],0));
            visited[i][startY[i]][startX[i]] = true;
            maxHarvest[i] = arr[startY[i]][startX[i]];

            while(!q.isEmpty()){
                Point cur = q.poll();
                int cx = cur.x;
                int cy = cur.y;
                int time = cur.time;

                if(time == 3) continue;

                for(int[] dir : directions){
                    int nx = cx+dir[0];
                    int ny = cy+dir[1];

                    if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[i][ny][nx]){
                        visited[i][ny][nx] = true;
                        q.add(new Point(ny,nx,time+1));
                        maxHarvest[i] += arr[ny][nx];
                    }
                }
            }
        }
        int ans = Arrays.stream(maxHarvest).sum();
        System.out.println(ans);
    }
}
