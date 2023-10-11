import java.util.*;
import java.io.*;
public class BOJ14889 {
    static int n;
    static int[][] arr;
    static int MIN = Integer.MAX_VALUE;
    static boolean[] visit;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n][n];
        visit = new boolean[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        combi(0,0);
        System.out.println(MIN);
    }
    public static void combi(int idx, int cnt){
        if(cnt == n/2){
            diff();
            return;
        }
        for(int i=idx; i<n ;i++){
            if(!visit[i]){
                visit[i] = true;
                combi(i+1, cnt+1);
                visit[i] = false;
            }
        }
    }

    public static void diff(){
        int team_start = 0;
        int team_link = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(visit[i] == true && visit[j] == true){
                    team_start += arr[i][j];
                    team_start += arr[j][i];
                }
                else if(visit[i] == false && visit[j] == false){
                    team_link+=arr[i][j];
                    team_link+=arr[j][i];
                }
            }
        }
        int val = Math.abs(team_start-team_link);

        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }
        MIN = Math.min(val, MIN);
    }
}
