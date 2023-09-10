import java.math.BigInteger;
import java.util.Scanner;

public class BOJ24723 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(BigInteger.valueOf(1).shiftLeft(n));
    }
}
