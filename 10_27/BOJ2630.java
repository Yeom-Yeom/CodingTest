import java.util.*;
import java.io.*;
public class BOJ2630 {
    public static int white = 0;
    public static int blue = 0 ;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void partition(int row, int col, int size){
        if(colorCheck(row,col,size)){
            if(arr[row][col] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }
        int newSize = size/2;
        partition(row, col, newSize);
        partition(row,col+newSize, newSize);
        partition(row+newSize, col, newSize);
        partition(row+newSize, col+newSize, newSize);
    }

    public static boolean colorCheck(int row, int col, int size){
        int color = arr[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(arr[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}
