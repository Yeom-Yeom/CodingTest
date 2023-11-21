import java.util.Scanner;

public class SWEA11315 {
    static int[][] drc = {{1,-1},{1,0},{1,1},{0,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++){
            int n = sc.nextInt();
            char[][] arr = new char[n][n];
            for(int i=0; i<n; i++){
                arr[i] = sc.next().toCharArray();
            }
            boolean flag = false;
            all: for(int r=0; r<n; r++){
                for(int c=0; c<n; c++){
                    if(arr[r][c] == 'o'){
                        flag = check(arr,r,c,n);
                        if(flag){
                            break all;
                        }
                    }
                }
            }
            if(flag){
                System.out.println("#"+tc+" YES");
            }else System.out.println("#"+tc+" NO");

        }
    }
    static boolean check(char[][] arr, int r, int c, int size){
        for(int d=0; d<4; d++){
            for(int k=1; k<=4; k++){
                int nr = r+drc[d][0]*k;
                int nc = c+drc[d][1]*k;

                if(nr >=0 && nr<size && nc>=0 && nc<size && arr[nr][nc] == 'o'){
                    if(k==4){
                        return true;
                    }
                }else
                    break;
            }
        }
        return false;
    }
}
