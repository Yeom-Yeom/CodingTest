import java.util.*;
public class BOJ17103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        boolean[] prime = new boolean[1000001];
        prime[0] = true;
        prime[1] = true;
        for(int i=2; i<=Math.sqrt(1000000); i++){
            if(prime[i]) continue;
            for(int j=i*i; j<1000001; j+=i){
                prime[j] = true;
            }
        }
        for(int i=0; i<t; i++){
            int cnt = 0;
            int n = sc.nextInt();
            for(int j=2; j<=n/2; j++){
                if(!prime[j] && !prime[n-j])
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}
