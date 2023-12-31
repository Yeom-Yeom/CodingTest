import java.util.*;
import java.io.*;
public class BOJ2470 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int i=0;
        int j = arr.length-1;

        int gap = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        int tmp,sum;
        while(i<j){
            sum = arr[i]+arr[j];
            tmp = Math.abs(sum);
            if(tmp<gap){
                gap = tmp;
                ans1 = arr[i];
                ans2 = arr[j];
            }
            if(sum>0){
                j--;
            }
            else i++;
        }
        System.out.println(ans1+" " +ans2);
    }
}
