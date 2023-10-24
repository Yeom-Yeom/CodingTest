import java.util.Scanner;

public class BOJ24416 {
    public static int count_1 = 1, count_2 = 1;
    public static int n;
    public static int f[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        fib(n);
        fibonacci(n);
        System.out.println(count_1+" "+count_2);
    }
    public static int fib(int n){
        if(n==1 || n==2) return 1;
        else{
            count_1++;
            return (fib(n-1)+fib(n-2));
        }
    }
    public static int fibonacci(int n){
        f = new int[n+1];
        f[1] = f[2] = 1;
        for(int i=3; i<n; i++){
            f[i] = f[i-1]+f[i-2];
            count_2++;
        }
        return f[n];
    }
}
