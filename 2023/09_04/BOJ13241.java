import java.util.*;
public class BOJ13241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long d = gcd(a,b);
        long ans = (a*b)/d;
        System.out.println(ans);
    }
    public static long gcd(long a, long b){
        while(b!=0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
