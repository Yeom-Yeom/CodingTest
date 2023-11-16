import java.util.Scanner;

public class SWEA17319 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int n = sc.nextInt();
            String s = sc.next();
            String tmp1 = s.substring(0,n/2);
            String tmp2 = s.substring(n/2, n);
            if(!tmp1.equals(tmp2) || n==1){
                System.out.println("#"+test_case+" No");
            }
            else{
                System.out.println("#"+test_case+" Yes");
            }
        }
    }
}
