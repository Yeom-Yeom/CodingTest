import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA17642 {
    static StringBuilder answer = new StringBuilder();
    static Reader scanner = new Reader();

    static long a0;
    static long b0;

    static void input() {
        a0 = scanner.nextLong();
        b0 = scanner.nextLong();
    }

    static void solution() {
        long diff = b0 - a0;
        if(diff < 0 || diff == 1) {
            answer.append(-1).append('\n');
            return;
        }

        if(diff % 2 == 0) {
            answer.append(diff / 2).append('\n');
            return;
        }

        long primeNumberCount = 1;
        diff -= 3;
        primeNumberCount += diff / 2;
        answer.append(primeNumberCount).append('\n');
    }

    public static void main(String args[]) {
        int T = scanner.nextInt();
        for(int test = 1; test <= T; test++) {
            answer.append('#').append(test).append(' ');
            input();
            solution();
        }

        System.out.print(answer);
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        public Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }

}
