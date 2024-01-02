import java.util.Scanner;

public class BOJ10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long res = 0;
        long[] arr = new long[n+1];
        long[] cnt = new long[m];

        for(int i=1; i<n+1; i++){
            arr[i] = (arr[i-1]+sc.nextInt())%m;
            if(arr[i]==0) res++;
            cnt[(int)arr[i]]++;
        }
        for(int i=0; i<m; i++){
            if(cnt[i]>1){
                res+=(cnt[i]* (cnt[i]-1)/2);
            }
        }
        System.out.println(res);
    }
}
