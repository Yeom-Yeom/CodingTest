import java.util.Scanner;

public class SWEA11688 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++){
            String s = sc.next();
            int l=1, r=1;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='L'){
                    l=l;
                    r = l+r;
                }
                else{
                    l = r+l;
                    r = r;
                }
            }
            System.out.println("#"+tc+" "+l+" "+r);
        }
    }
}
