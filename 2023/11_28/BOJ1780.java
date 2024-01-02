import java.util.*;
import java.io.*;
public class BOJ1780 {
    public static int[][] board;
    public static int GRAY = 0;
    public static int WHITE = 0;
    public static int BLACK = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0,0,n);
        System.out.println(GRAY);
        System.out.println(WHITE);
        System.out.println(BLACK);
    }

    public static void partition(int row, int col, int size){
        if(colorCheck(row,col,size)){
            if(board[row][col] == -1){
                GRAY++;
            }
            else if(board[row][col] == 0){
                WHITE++;
            }
            else{
                BLACK++;
            }
            return;
        }
        int newSize = size/3;
        partition(row, col, newSize);
        partition(row, col+newSize, newSize);
        partition(row, col+2*newSize, newSize);
        partition(row+newSize, col, newSize);
        partition(row+newSize, col+newSize, newSize);
        partition(row+newSize, col+2*newSize, newSize);
        partition(row+2*newSize, col, newSize);
        partition(row+2*newSize, col+newSize, newSize);
        partition(row+2*newSize, col+2*newSize, newSize);
    }

    public static boolean colorCheck(int row, int col ,int size){
        int color = board[row][col];

        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(color!= board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
