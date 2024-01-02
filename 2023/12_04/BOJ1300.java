import java.util.*;
public class BOJ1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long lo = 1;
        long hi = k;
        while(lo<hi){
            long mid = (lo+hi)/2;
            long cnt = 0;
            for(int i=1; i<=n; i++){
                cnt += Math.min(mid/i, n);
            }
            if(k<=cnt){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        System.out.println(lo);
    }
}
