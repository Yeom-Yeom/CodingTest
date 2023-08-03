import java.util.*;

public class BOJ10101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> n = new ArrayList<Integer>();
        int sum = 0;
        boolean same;
        boolean triple;
        for(int i=0; i<3; i++){
            n.add(sc.nextInt());
            sum += n.get(i);
        }
        if(n.get(0) == n.get(1) || n.get(1) == n.get(2) || n.get(0) == n.get(2))
            same = true;
        else same = false;
        if(n.get(0) == n.get(1) && n.get(1) == n.get(2))
            triple = true;
        else triple  = false;
        if(sum!=180){
            System.out.println("Error");
        }
        else if(triple){
            System.out.println("Equilateral");
        }
        else if(same){
            System.out.println("Isosceles");
        }else{
            System.out.println("Scalene");
        }

    }
}
