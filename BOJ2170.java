import java.util.*;
import java.io.*;
public class BOJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] pos = new int[n][2];
        int res = 0;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pos, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int min = pos[0][0];
        int max = pos[0][1];
        int len = max-min;

        for(int i=1; i<n; i++){
            if(min<=pos[i][0] && pos[i][1] <= max){
                continue;
            }else if(pos[i][0] < max){
                len += pos[i][1] - max;
            }
            else len += pos[i][1] - pos[i][0];
            min = pos[i][0];
            max = pos[i][1];
        }
        System.out.println(len);
    }
}
