import java.io.*;
import java.util.*;
public class BOJ1269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for(int i=0; i<n; i++){
            int tmp = sc.nextInt();
            setA.add(tmp);
        }
        for(int i=0; i<m; i++){
            int tmp = sc.nextInt();
            setB.add(tmp);
        }
        int ans = 0;
        for(int num : setA){
            if(!setB.contains(num))
                ans++;
        }
        for(int num : setB){
            if(!setA.contains(num))
                ans++;
        }
        System.out.println(ans);
    }
}
