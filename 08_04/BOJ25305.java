import java.util.*;
public class BOJ25305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        arr.sort(Comparator.reverseOrder());
        System.out.println(arr.get(k-1));
    }
}
