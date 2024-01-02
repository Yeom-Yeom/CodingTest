import java.util.Scanner;

public class SWEA12368 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = a+b;
            while(ans>24){
                ans%=24;
            }
            if(ans == 24){
                ans = 0;
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
