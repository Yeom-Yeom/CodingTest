import java.util.*;
public class PGMS_MakeBigNumber {
    public static void main(String[] args) {

    }
    public String solution(String number, int k){
        String ans = "";
        StringBuilder ansBuilder = new StringBuilder();

        char[] arr = number.toCharArray();
        int len = arr.length-k;

        int start = 0;
        for(int i=0 ;i<len;i ++){
            char max = '0';
            for(int j=start; j<=i+k; j++){
                if(arr[j]>max){
                    max = arr[j];
                    start = j+1;
                }
            }
            ansBuilder.append(Character.toString(max));
        }
        ans = ansBuilder.toString();
        return ans;
    }
}
