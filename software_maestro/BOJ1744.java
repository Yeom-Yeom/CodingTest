import java.util.*;
public class BOJ1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int[] arr = new int[n];
        int minusCnt = 0;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            if(arr[i] <= 0){
                minusCnt++;
            }
        }
        Arrays.sort(arr);
        for(int i=1; i<minusCnt; i+=2){
            ans += arr[i-1]*arr[i];
        }
        if(minusCnt%2==1){
            ans += arr[minusCnt-1];
        }
        if((n-minusCnt) %2 == 1){
            ans += arr[minusCnt];
        }
        for(int i = n-1; i>minusCnt; i-=2){
            int mul = arr[i]*arr[i-1];
            int sum = arr[i]+arr[i-1];
            if(mul>sum){
                ans += mul;
            }else ans+=sum;
        }
        System.out.println(ans);
    }
}
