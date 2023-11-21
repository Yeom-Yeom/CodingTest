import java.util.Scanner;

public class SWEA11736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 1; i < n - 1; i++) {
                if (arr[i - 1] < arr[i] && arr[i + 1] > arr[i]) {
                    cnt++;
                } else if (arr[i - 1] > arr[i] && arr[i + 1] < arr[i]) {
                    cnt++;
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}