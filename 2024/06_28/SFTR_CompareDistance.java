import java.util.*;
public class SFTR_CompareDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a>b) System.out.println("A");
        else if(a<b) System.out.println("B");
        else System.out.println("same");
    }
}
