
import java.util.*;
import java.io.*;
public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[n+1];
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++) {
            String s = br.readLine();
            map.put(s, i);
            arr[i] = s;
        }
        while(m-->0){
            String findStr = br.readLine();
            if(isStringNumber(findStr)){
                int idx = Integer.parseInt(findStr);
                sb.append(arr[idx]);
            }else{
                sb.append(map.get(findStr));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static boolean isStringNumber(String s){
        try{
            Double.parseDouble(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
