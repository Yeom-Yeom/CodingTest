import java.util.*;
import java.io.*;

public class BOJ3190 {
    static int n,k,l;
    static int[][]map;
    static List<int[]> snake = new ArrayList<>();
    static HashMap<Integer, String> hash = new HashMap<>();
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            map[a][b] = 1;
        }
        l = Integer.parseInt(br.readLine());
        for(int i=0; i<l ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            hash.put(x,c);
        }
        solve();
    }
    public static void solve(){
        int cx = 0, cy = 0;
        int time = 0;
        int d = 0;
        snake.add(new int[] {0,0});
        while (true) {
            // 1. 시간 재기
            time++;

            //2. 뱀 이동하기
            int nx = cx+dx[d];
            int ny = cy+dy[d];

            // 3. 범위를 벗어나거나, 뱀 몸통 만날 때 종료
            if(isFinish(nx,ny)) break;

            // 4. 사과가 있을 때 없을 때 처리
            if(map[nx][ny] == 1){
                map[nx][ny] = 0;
                snake.add(new int[] {nx,ny});
            }else{
                snake.add(new int[] {nx, ny});
                snake.remove(0);
            }

            // 5. 방향을 바꿔주는 시간을 만날 때 방향 변경
            if(hash.containsKey(time)){
                if(hash.get(time).equals("D")){
                    d+=1;
                    if(d==4)
                        d=0;
                }else{
                    d-=1;
                    if(d==-1)
                        d=3;
                }
            }

            // 6. 현재 값 업데이트
            cx = nx;
            cy = ny;
        }
        System.out.println(time);
    }
    public static boolean isFinish(int nx, int ny){
        // 다음 위치가 보드판 밖으로 나갔는지
        if(nx<0 || ny <0 || nx >= n || ny >=n){
            return true;
        }
        // 뱀 몸통이랑 닿았는지
        for(int i=0 ; i<snake.size(); i++){
            int[] t = snake.get(i);
            if(nx == t[0] && ny == t[1])
                return true;
        }
        return false;
    }
}
