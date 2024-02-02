import java.util.*;
import java.io.*;
public class TrueFilialPiety {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[3][3];
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans1 = 0, ans2 = 0;
        for(int i=0; i<3; i++){
            if(arr[i][0] == 1 || arr[i][1] == 1 || arr[i][2] == 1){
                if(arr[i][0] == 3 || arr[i][1] == 3 || arr[i][2] == 3){
                    ans1 = 2;
                }
                else if(arr[i][0] == 2 || arr[i][1] == 2 || arr[i][2] == 2){
                    ans1 = 1;
                }
                else ans1 = 0;
            }
        }
        System.out.println(ans1);
        for(int i=0; i<3; i++){
            if(arr[0][i] == 1 || arr[1][i] == 1 || arr[2][i] == 1){
                if(arr[0][i] == 3 || arr[1][i] == 3 || arr[2][i] == 3){
                    ans2 = 2;
                }
                else if(arr[0][i] == 2 || arr[1][i] == 2 || arr[2][i] == 2){
                    ans2 = 1;
                }
                else ans2 = 0;
            }
        }
        System.out.println(Math.min(ans1,ans2));
    }
}
