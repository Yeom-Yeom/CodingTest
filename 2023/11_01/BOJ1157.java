import java.util.*;
import java.io.*;
public class BOJ1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            if('a' <= s.charAt(i) && s.charAt(i) <='z'){
                arr[s.charAt(i)-97]++;
            }else{
                arr[s.charAt(i)-65]++;
            }
        }
        int max = -1;
        char ch = '?';
        for(int i=0; i<26; i++){
            if(arr[i] > max){
                max = arr[i];
                ch = (char)(i+65);
            }
            else if(arr[i] == max){
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}
