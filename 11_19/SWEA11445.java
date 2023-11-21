import java.util.Scanner;

public class SWEA11445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++){
            String p = sc.next();
            String q = sc.next();
            if(!(p+"a").equals(q)){
                System.out.println("#"+tc+" Y");
            }
            else System.out.println("#"+tc+" N");
        }
    }
}
