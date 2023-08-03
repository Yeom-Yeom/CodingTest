import java.util.*;
public class BOJ1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt(), h = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(a);
        arr.add(b);
        arr.add(w - a);
        arr.add(h - b);
        arr.sort(Comparator.naturalOrder());
        System.out.println(arr.get(0));
    }
}