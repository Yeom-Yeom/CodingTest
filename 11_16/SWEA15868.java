import java.util.*;

public class SWEA15868 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        boolean XOR = false;
        for(int test_case = 1; test_case<=T; test_case++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for(int i=0; i<n; i++){
                String s = sc.next();
                for(int j= 0; j<m; j++){
                    arr[i][j] = Character.getNumericValue(s.charAt(j));
                }
            }
            for(int i=0; i<n; i++){
                if(arr[i][i] == 0){
                    XOR = true;
                }else XOR = false;
            }
            if(XOR) System.out.println("#"+test_case+" yes");
            else System.out.println("#"+test_case+" no");
        }
    }
}
