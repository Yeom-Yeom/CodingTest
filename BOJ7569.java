import java.util.*;
import java.io.*;
class Point{
    int height;
    int row;
    int col;
    public Point(int height, int row, int col){
        this.height = height;
        this.row = row;
        this.col = col;
    }
}
public class BOJ7569 {
    static int rowArr[] = {-1,0,1,0,0,0};
    static int colArr[] = {0,1,0,-1,0,0};
    static int heightArr[] = {0,0,0,0,1,-1};
    static int m,n,h;
    static int[][][] arr;
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h+1][n+1][m+1];
        for(int i=1; i<=h; i++){
            for(int j=1; j<=n ;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=1; k<=m; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) q.add(new Point(i,j,k));
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        while(!q.isEmpty()){
            Point point = q.poll();
            int height = point.height;
            int row = point.row;
            int col = point.col;
            for(int i=0; i<6; i++){
                int nHeight = height+heightArr[i];
                int nRow = row+rowArr[i];
                int nCol = col+colArr[i];
                if(checkPoint(nHeight, nRow, nCol)){
                    q.add(new Point(nHeight,nRow,nCol));
                    arr[nHeight][nRow][nCol] = arr[height][row][col]+1;
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i=1; i<=h; i++){
            for(int j=1; j<=n ;j++){
                for(int k=1; k<=m; k++){
                    if(arr[i][j][k] == 0) return -1;
                    res = Math.max(res, arr[i][j][k]);
                }
            }
        }
        if(res == 1) return 0;
        else return res-1;
    }
    private static boolean checkPoint(int height, int row, int col){
        if(height < 1 || height > h || row<1 || row> n || col <1 || col>m) return false;
        if(arr[height][row][col] == 0) return true;
        else return false;
    }
}
