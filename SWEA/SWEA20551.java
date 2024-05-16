import java.util.*;
public class SWEA20551 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc<=t; tc++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int cnt = 0;
            if(b==1 || c<3){
                cnt = -1;
            }else{
                while(a>=b){
                    a--;
                    cnt++;
                }
                while(c-a<2){
                    a--;
                    cnt++;
                }
                while(b>=c){
                    b--;
                    cnt++;
                }
            }
            System.out.println("#"+tc+" " +cnt);
        }
    }
}
