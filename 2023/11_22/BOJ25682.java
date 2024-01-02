import java.util.*;
import java.io.*;
public class BOJ25682 {
    static int n,m,k;
    static char[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        String line;
        for(int i=0; i<n; i++){
            line = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = line.charAt(j);
            }
        }
        System.out.println(Math.min(min_board('B'), min_board('W')));
    }
    public static int min_board(char color){
        int cnt = Integer.MAX_VALUE;
        int value;
        int[][] prefix_sum =  new int[n+1][m+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i+j)%2==0){
                    value = board[i][j] != color? 1:0;
                }
                else{
                    value = board[i][j] == color? 1:0;
                }
                prefix_sum[i+1][j+1] = prefix_sum[i][j+1] + prefix_sum[i+1][j]-prefix_sum[i][j]+value;
            }
        }
        for(int i=1; i<=n-k+1; i++){
            for(int j=1; j<=m-k+1; j++){
                cnt = Math.min(cnt, prefix_sum[i+k-1][j+k-1]-prefix_sum[i + k - 1][j - 1] - prefix_sum[i - 1][j + k - 1] + prefix_sum[i - 1][j - 1]);
            }
        }
        return cnt;
    }
}
