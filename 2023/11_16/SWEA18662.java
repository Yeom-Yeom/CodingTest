import java.util.Scanner;

public class SWEA18662 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            double tmp1 = b - a, tmp2 = c - b;
            if (tmp1 == tmp2) {
                System.out.println("#" + test_case + " " + 0);
            } else {
                double res;
                if (tmp1 < tmp2) {
                    res = (tmp2 - tmp1) / 2;
                } else {
                    res = (tmp1 - tmp2) / 2;
                }
                System.out.println("#" + test_case + " " + Math.ceil(res * 10) / 10.0);
            }
        }
    }
}
