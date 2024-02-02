import java.util.*;
import java.io.*;
public class GBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][2];
        int[][] speed = new int[m][2];
        int ans = 0;
        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for(int i=0; i<m; i++){
            speed[i][0] = sc.nextInt();
            speed[i][1] = sc.nextInt();
        }
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=idx; j<m; j++){
                if(arr[i][0] < speed[j][0]){
                    speed[j][0] -= arr[i][0];
                    if(speed[j][1] - arr[i][1] > 0) ans = Math.max(ans,speed[j][1]-arr[i][1]);
                    break;
                }else if(arr[i][0] > speed[j][0]){
                    arr[i][0] -= speed[j][0];
                    if(speed[j][1] - arr[i][1] > 0) ans = Math.max(ans,speed[j][1] - arr[i][1]);
                    idx++;
                }else{
                    if(speed[j][1] - arr[i][1] > 0) ans = Math.max(ans,speed[j][1] - arr[i][1]);
                    idx++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
