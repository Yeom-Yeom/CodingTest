import java.util.Scanner;

public class SWEA11387 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++){
            int d = sc.nextInt();
            int l = sc.nextInt();
            int n = sc.nextInt();
            int ans = 0;
            for(int i=0; i<n; i++){
                ans+= (d*(1+i*0.01*l));
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
}
