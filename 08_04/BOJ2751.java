import java.util.*;
public class BOJ2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        for(int value : arr){
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}
