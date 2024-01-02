import java.util.Scanner;

public class SWEA12221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = -1;
            if(a<10 && b<10){
                ans = a*b;
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
