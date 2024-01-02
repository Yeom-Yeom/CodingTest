import java.util.Scanner;

public class SWEA10726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = (1<<n)-1;
            if((m&x) == x){
                System.out.println("#"+tc+" ON");
            }else{
                System.out.println("#"+tc+" OFF");
            }
        }
    }
}
