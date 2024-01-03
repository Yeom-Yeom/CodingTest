import java.util.*;
public class BOJ1644 {
    static int n;
    static int ans;
    static int[] arr;
    static List<Integer> primeNum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
        primeNum = new ArrayList<Integer>();

        findPrime();
        ans = 0;
        twoPointer();
        System.out.println(ans);
    }
    static void findPrime(){
        for(int i=2; i<=n; i++){
            if(arr[i] == 0){
                primeNum.add(i);
                for(int j=i; j<=n; j=j+i){
                    arr[j] = 1;
                }
            }
        }
    }

    static void twoPointer(){
        int sum=0, high = 0, low=0;
        while(true){
            if(sum>=n){
                sum -= primeNum.get(low);
                low+=1;
            }else if(high==primeNum.size()){
                break;
            }else if(sum<n){
                sum+=primeNum.get(high);
                high+=1;
            }
            if(sum==n){
                ans+=1;
            }
        }
    }
}
