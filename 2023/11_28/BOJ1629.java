import java.util.*;
import java.io.*;
public class BOJ1629 {
    public static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        System.out.println(pow(a,b));
    }
    public static long pow(long a, long exponent){
        if(exponent == 1){
            return a%c;
        }
        long tmp = pow(a,exponent/2);
        if(exponent%2 == 1){
            return (tmp*tmp%c)*a%c;
        }
        return tmp*tmp%c;
    }
}
