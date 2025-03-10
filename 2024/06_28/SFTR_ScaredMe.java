import java.util.*;
import java.io.*;
public class SFTR_ScaredMe {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] split = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int row = split[0];
        int col = split[1];

        List<int[]> ghosts = new ArrayList<>();
        int[] namwoo = new int[2];
        int[] goal = new int[2];

        String[][] map = new String[row][col];

        for(int r = 0; r<row; r++){
            String[] tmpRow = br.readLine().split("");
            for(int c = 0; c<col; c++){
                String ch = tmpRow[c];
                map[r][c] = ch;
                if(ch.equals("N")){
                    namwoo = new int[]{r,c};
                }else if(ch.equals("G")){
                    ghosts.add(new int[]{r,c});
                }else if(ch.equals("D")){
                    goal = new int[]{r,c};
                }
            }
        }

        int namwooTime = bfs(map, namwoo, false);

        final int[] finalGoal = goal;

        ghosts.sort(Comparator.comparingInt(
                gh->{
                    final int absRow = Math.abs(finalGoal[0] - gh[0]);
                    final int absCol = Math.abs(finalGoal[1]-gh[1]);

                    return absRow+absCol;
                }
        ));

        final int ghostTime = bfs(map,ghosts.get(0),true);

        if(namwooTime == -1){
            System.out.println("No");
            return;
        }
        System.out.println(ghostTime <= namwooTime ? "No" : "Yes");

    }

    private static int bfs(final String[][] map, int[] obj, boolean isWallPass){
        int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] isVisited = new boolean[map.length][map[0].length];

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{obj[0],obj[1],0});

        isVisited[obj[0]][obj[1]] = true;

        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            if(map[cur[0]][cur[1]].equals("D")){
                return cur[2];
            }
            for(int[] direction : directions){
                int nRow = cur[0] + direction[0];
                int nCol = cur[1] + direction[1];

                if(isOutMap(map, nRow, nCol)){
                    continue;
                }
                if(isVisited[nRow][nCol]){
                    continue;
                }
                if(!isWallPass && map[nRow][nCol].equals("#")){
                    continue;
                }
                isVisited[nRow][nCol] = true;
                dq.addLast(new int[]{nRow,nCol,cur[2]+1});
            }
        }
        return -1;
    }

    private static boolean isOutMap(String[][] map, int row, int col){
        return row<0 || row>=map.length || col < 0 || col>=map[0].length;
    }
}
