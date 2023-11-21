import java.util.Scanner;

public class SWEA12004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int n = sc.nextInt();
            String ans = " No";
            for(int i=1; i<10; i++){
                if(n%i == 0 && n/i<10){
                    ans = " Yes";
                }
            }
            System.out.println("#"+tc+ans);
        }
    }

}
