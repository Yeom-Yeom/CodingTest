import java.util.*;
public class PGMS_FindPrimeNumber {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] check = new boolean[7];
    public int solution(String numbers){
        int ans = 0;
        for(int i=0; i<numbers.length(); i++){
            dfs(numbers,"",i+1);
        }
        for(int i=0; i<arr.size(); i++){
            if(prime(arr.get(i))) ans++;
        }
        return ans;
    }

    public static void dfs(String str, String tmp, int m){
        if(tmp.length() == m){
            int num = Integer.parseInt(tmp);
            if(!arr.contains(num)){
                arr.add(num);
            }
        }
        for(int i=0; i<str.length(); i++){
            if(!check[i]){
                check[i] = true;
                tmp += str.charAt(i);
                dfs(str, tmp, m);
                check[i] = false;
                tmp = tmp.substring(0,tmp.length()-1);
            }
        }
    }

    public static boolean prime(int n){
        if(n<2) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i==0) return false;
        }
        return true;
    }


}
