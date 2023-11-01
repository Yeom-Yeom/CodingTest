import java.util.*;
import java.io.*;
public class SofteerSafeBreaker {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<n ;i++){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(list,(o1,o2)->o2[1]-o1[1]);
        int ans = 0;
        for(int[] item : list){
            if(w <= item[0]){
                ans+= w*item[1];
                break;
            }else{
                ans+= item[0]*item[1];
                w-=item[0];
            }
        }
        System.out.println(ans);
    }
}
