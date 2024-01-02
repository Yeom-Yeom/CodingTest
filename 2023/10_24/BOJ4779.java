import java.util.*;
import java.io.*;
public class BOJ4779 {
    static int n;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            n = Integer.parseInt(str);
            answer = new StringBuilder();
            int len = (int)Math.pow(3,n);
            for(int i=0; i<len; i++){
                answer.append("-");
            }
            func(0,len);
            System.out.println(answer);
        }

    }
    public static void func(int start, int size){
        if(size==1){
            return;
        }
        int newSize = size/3;
        for(int i=start+newSize; i<start+2*newSize; i++){
            answer.setCharAt(i,' ');
        }
        func(start,newSize);
        func(start+2*newSize, newSize);
    }
}
