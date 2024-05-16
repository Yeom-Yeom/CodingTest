import java.util.*;
public class SWEA20731 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int tc=1; tc<=t; tc++){
            int n = sc.nextInt();
            sc.nextLine();
            char[][] grid = new char[n][n];
            for(int i=0; i<n; i++){
                grid[i] = sc.nextLine().toCharArray();
            }

            boolean isPossible  = false;

            for(int k=0; k<n && !isPossible; k++){
                boolean valid = true;
                
                for(int i=0; i<n && valid; i++){
                    for(int j=0; j<n && valid; j++){
                        if(grid[i][j] == '1'){
                            if(gcd(i+k+1, j+k+1)!= 1)
                                valid = false;
                        }
                    }
                }
                if(valid){
                    isPossible = true;
                }
            }
            if(isPossible) System.out.println("#"+tc+" YES");
            else System.out.println("#"+tc+" NO");
        }
    }

    private static int gcd(int a, int b){
        while(b!=0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
}
