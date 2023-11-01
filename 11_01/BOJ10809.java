import java.util.Scanner;

public class BOJ10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] arr = new int [26];
        for(int i=0; i<26; i++){
            arr[i] = -1;
        }
        char[] cArr = {'a','b','c','d','e','f','g','h','i','j','k','l','m'
        ,'n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<26; j++){
                if(s.charAt(i) == cArr[j] && arr[j]==-1){
                    arr[j] = i;
                }
            }
        }
        for(int i=0; i<26; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
