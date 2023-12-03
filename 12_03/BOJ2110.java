import java.util.*;

public class BOJ2110 {
    public static int[] house;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        house = new int[n];
        for(int i=0; i<n; i++){
            house[i] = sc.nextInt();
        }
        Arrays.sort(house);

        int lo = 1;
        int hi = house[n-1] - house[0]+1;
        while(lo<hi){
            int mid = (hi+lo)/2;

            if(canInstall(mid)<c){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        System.out.println(lo-1);
    }
    public static int canInstall(int distance){
        int cnt = 1;
        int lastLocate = house[0];
        for(int i=1; i<house.length; i++){
            int locate = house[i];
            if(locate-lastLocate >= distance){
                cnt++;
                lastLocate = locate;
            }
        }
        return cnt;
    }
}
