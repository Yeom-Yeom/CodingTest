import java.io.*;
public class BOJ24265 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        br.close();
        System.out.println(n*(n-1)/2);
        System.out.println(2);
    }
}
