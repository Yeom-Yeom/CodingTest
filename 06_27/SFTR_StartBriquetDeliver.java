import java.util.*;
public class SFTR_StartBriquetDeliver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int ans = 0;
        int near_dist = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=n-1; i>0; i--){
            if(arr[i]-arr[i-1]<near_dist){
                near_dist = arr[i]-arr[i-1];
            }
        }

        for(int i=n-1; i>0; i--){
            if(arr[i]-arr[i-1] == near_dist)
                ans++;
        }

        System.out.println(ans);
    }
}
