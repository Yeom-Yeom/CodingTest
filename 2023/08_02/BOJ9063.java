import java.util.*;
public class BOJ9063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            a.add(sc.nextInt());
            b.add(sc.nextInt());
        }
        a.sort(Comparator.naturalOrder());
        b.sort(Comparator.naturalOrder());
        int w = a.get(n-1)-a.get(0);
        int h = b.get(n-1)-b.get(0);
        System.out.println(w*h);

    }
}
