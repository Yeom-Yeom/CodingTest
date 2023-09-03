import java.io.*;
import java.util.*;

public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n ;i++){
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            String tmp = br.readLine();
            if (set.contains(tmp)) {
                list.add(tmp);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(String s : list){
            System.out.println(s);
        }

    }
}
