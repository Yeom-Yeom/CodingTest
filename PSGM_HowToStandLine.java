import java.util.*;
public class PSGM_HowToStandLine {
    public static void main(String[] args) {

    }

    public int[] solution(int n, long k){
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();

        long f = 1;
        for(int i=1; i<=n; i++){
            list.add(i);
            f*=i;
        }
        k--;
        int idx = 0;
        while(idx<n){
            f = f/(n-idx);
            ans[idx++] = list.remove((int) (k/f));
            k = k%f;
        }
        return ans;

    }
}
