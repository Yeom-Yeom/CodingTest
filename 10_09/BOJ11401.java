import java.util.*;
public class BOJ11401 {
    static long n,k;
    static long P = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        k = sc.nextLong();

        long numer = factorial(n);
        long denom = factorial(k)*factorial(n-k) %P;

        System.out.println(numer*pow(denom,P-2)%P);
    }

    public static long factorial(long n){
        long fac = 1L;
        while(n>1){
            fac = (fac*n)%P;
            n--;
        }
        return fac;
    }

    public static long pow(long base, long expo){
        if(expo == 1) return base%P;
        long tmp = pow(base,expo/2);
        if(expo%2 ==1){
            return (tmp*tmp%P)*base%P;
        }
        return tmp*tmp%P;
    }

}
