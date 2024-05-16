import java.util.*;
public class SWEA20019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=1; tc<=t; tc++){
            String s = sc.next();
            int mid = s.length()/2;
            boolean isRotate = true;
            for(int i=0; i<mid; i++){
                if(s.charAt(i)==s.charAt(i+mid+1)){
                    continue;
                }
                else{
                    isRotate = false;
                    break;
                }
            }
            if(isRotate) System.out.println("#"+tc+" YES");
            else System.out.println("#"+tc+" NO");
        }

    }
}
