import java.util.*;
public class SFTR_PlantingTrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(ans<arr[i]*arr[j]){
                    ans = arr[i]*arr[j];
                }
            }
        }

        System.out.println(ans);
    }
}
