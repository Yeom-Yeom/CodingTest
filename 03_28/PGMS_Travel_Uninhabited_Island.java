import java.util.*;
public class PGMS_Travel_Uninhabited_Island {
    public static void main(String[] args) {
        System.out.println(solution(["X591","X1X5X","X231X","1XXX1"]));
    }

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static char[][] map;
    static ArrayList<Integer> answer;
    public static List<Integer> solution(String[] maps){
        List<Integer> ans = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++){
            map[i] = maps[i].toCharArray();
        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(!visited[i][j] && map[i][j]!='X'){
                    ans.add(bfs(i,j));
                }
            }
        }
        if(ans.size() == 0){
            ans.add(-1);
        }
        Collections.sort(ans);
        return ans;
    }

    public static int bfs(int x, int y){
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            sum += map[cx][cy]-'0';
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<map.length && ny<map[0].length && !visited[nx][ny] && map[nx][ny]!='X'){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return sum;
    }
}
