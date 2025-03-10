import java.util.*;
public class SFTR_DangerFilialPiety {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();

        int t = 0;
        int n = (d>a)? d / a : 0;
        int m = (d>b)? d / b : 0;

        t = 2*d + a*m + b*n;
        System.out.println(t);
    }
}
