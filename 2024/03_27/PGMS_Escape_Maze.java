import java.util.*;
public class PGMS_Escape_Maze {
    public static void main(String[] args) {

    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static String[][] maze;
    public int solution(String[] maps){
        maze = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] labor = new int[2];

        for(int i=0; i<maps.length; i++){
            String[] tmp = maps[i].split("");
            for(int j=0; j<tmp.length; j++){
                maze[i][j] = tmp[j];
                if(maze[i][j].equals("S")){
                    start = new int[]{i,j};
                }
                if(maze[i][j].equals("L")){
                    labor = new int[]{i,j};
                }
            }
        }
        int res = bfs(start,"L");
        int res1 = bfs(labor, "E");

        if(res == -1 || res1 == -1){
            return -1;
        }
        return res+res1;
    }

    public static int bfs(int[] start, String target){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0],start[1], 0});

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int cnt = queue.peek()[2];
            visited[x][y] = true;

            if (maze[x][y].equals(target)) {
                return cnt;
            }

            queue.poll();

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && !visited[nx][ny]){
                    if(!maze[nx][ny].equals("X")){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny,cnt+1});
                    }
                }
            }
        }
        return -1;
    }

}
