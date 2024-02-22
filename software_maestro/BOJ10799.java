import java.io.*;
import java.util.*;
public class BOJ10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] sl = str.split("");
        Stack<String> st = new Stack<>();
        int cnt = 0;
        for(int i=0; i<sl.length; i++){
            if(sl[i].equals("(")){
                st.push(sl[i]);
            }else if(sl[i].equals(")")){
                if(sl[i-1].equals("(")){
                    st.pop();
                    cnt+=st.size();
                }else{
                    st.pop();
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
