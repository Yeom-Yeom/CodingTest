import java.util.*;
import java.io.*;
public class BOJ2667 {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1, 0,0};
    static int apartNum = 0;
    static int[] aparts = new int[25*25];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        StringTokenizer st;
        for(int i=0 ;i<n; i++){
            String input = sc.next();
            for(int j=0; j<n; j++){
                arr[i][j] = input.charAt(j)-'0';
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    apartNum++;
                    dfs(i,j);
                }
            }
        }
        Arrays.sort(aparts);
        System.out.println(apartNum);
        for(int i=0 ;i<aparts.length; i++){
            if(aparts[i] != 0)
                System.out.println(aparts[i]);
        }
    }
    public static void dfs(int x,int y){
        visited[x][y] = true;
        aparts[apartNum]++;
        for(int i=0 ;i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny <n){
                if(arr[nx][ny] == 1 && !visited[nx][ny])
                    dfs(nx,ny);
            }
        }
    }
}
