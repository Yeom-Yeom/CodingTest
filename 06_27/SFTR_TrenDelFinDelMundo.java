import java.util.*;
public class SFTR_TrenDelFinDelMundo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans_x = Integer.MAX_VALUE, ans_y = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
             if(y<ans_y){
                 ans_x = x;
                 ans_y = y;
             }
        }
        System.out.println(ans_x+" "+ans_y);
    }
}
