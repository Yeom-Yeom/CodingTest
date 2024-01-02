import java.io.*;
import java.util.StringTokenizer;

public class BOJ19532 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = ((c*e)-(b*f)) /((a*e) - (d*b));
        int y = ((c*d)-(f*a)) / ((d*b)-(a*e));
        System.out.print(x + " " + y);
    }
}
