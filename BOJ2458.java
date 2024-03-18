import java.util.*;
import java.io.*;
public class BOJ2458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int max = n*(n*(n-1)/2);
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = max;
            }
        }
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a-1][b-1] = 1;
        }
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j] > arr[i][k]+arr[k][j]){
                        arr[i][j] = arr[i][k]+arr[k][j];
                    }
                }
            }
        }
        int res = 0;
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(arr[i][j] < max || arr[j][i] < max) cnt++;
            }
            if(cnt==n-1) res++;
        }
        System.out.println(res);
    }
}
