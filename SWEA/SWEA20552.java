import java.util.*;
public class SWEA20552 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=1; tc<=t; tc++){
            long x = sc.nextLong();
            long s = sc.nextLong();

            if(x>s){
                System.out.println("-1");
                continue;
            }

            long diff = s-x;
            if((diff&1) != 0){
                System.out.println("-1");
                continue;
            }

            if(x==s){
                if(x==0){
                    System.out.println("0");
                }else{
                    System.out.println("1");
                    System.out.println(x);
                }
                continue;
            }

            long halfDiff = diff / 2;
            if((halfDiff&x) == 0){
                System.out.println("2");
                System.out.println((halfDiff+x)+" " + halfDiff);
            }else{
                System.out.println("3");
                System.out.println(halfDiff+" " + halfDiff+ " " + x);
            }


        }
    }
}
