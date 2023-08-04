import java.util.*;
public class BOJ2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<5; i++){
            arr.add(sc.nextInt());
            sum+=arr.get(i);
        }
        System.out.println(sum/5);
        arr.sort(Comparator.naturalOrder());
        System.out.println(arr.get(2));
    }
}
