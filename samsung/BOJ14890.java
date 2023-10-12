package samsung;

import java.util.*;
import java.io.*;
public class BOJ14890 {
    static int n,l;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(calRow(i)) cnt++;
            if(calCol(i)) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean calRow(int row){
        boolean[] isIncline = new boolean[n];
        for(int i=0; i<n-1; i++){
            int diff = map[row][i] - map[row][i+1];
            if(diff > 1 || diff<-1) return false;
            else if(diff == -1){
                for(int j=0; j<l; j++){
                    if(i-j<0 || isIncline[i-j]) return false;
                    if(map[row][i] != map[row][i-j]) return false;
                    isIncline[i-j] = true;
                }
            } else if (diff == 1) {

                for(int j=1; j<=l; j++){
                    if(i+j >=n || isIncline[i+j]) return false;
                    if(map[row][i]-1 != map[row][i+j]) return false;
                    isIncline[i+j] = true;
                }
            }
        }
        return true;
    }
    public static boolean calCol(int col){
        boolean[] isIncline = new boolean[n];
        for(int i=0; i<n-1; i++){
            int diff = map[i][col] - map[i+1][col];
            if(diff > 1 || diff<-1) return false;
            else if(diff == -1){
                for(int j=0; j<l; j++){
                    if(i-j<0 || isIncline[i-j]) return false;
                    if(map[i][col] != map[i-j][col]) return false;
                    isIncline[i-j] = true;
                }
            } else if (diff == 1) {

                for(int j=1; j<=l; j++){
                    if(i+j >=n || isIncline[i+j]) return false;
                    if(map[i][col]-1 != map[i+j][col]) return false;
                    isIncline[i+j] = true;
                }
            }
        }
        return true;
    }
}
