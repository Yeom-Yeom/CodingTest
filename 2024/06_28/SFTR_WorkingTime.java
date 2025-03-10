import java.util.*;
public class SFTR_WorkingTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = 0, m=0;
        for(int i=0; i<5; i++){
            String gotoWork = sc.next();
            String leaveWork = sc.next();
            int gh = Integer.parseInt(gotoWork.substring(0,2));
            int lh = Integer.parseInt(leaveWork.substring(0,2));
            h+= (lh-gh);
            int gm = Integer.parseInt(gotoWork.substring(3,5));
            int lm = Integer.parseInt(leaveWork.substring(3,5));
            m+= (lm-gm);
        }
        System.out.println(h*60+m);
    }
}
