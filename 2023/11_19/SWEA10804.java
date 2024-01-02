import java.util.Scanner;

public class SWEA10804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc =1; tc<=T; tc++){
            String s = sc.next();
            String ans = "";
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='b'){
                    ans+='d';
                }
                else if(s.charAt(i)=='d'){
                    ans+='b';
                }
                else if(s.charAt(i)=='p'){
                    ans+='q';
                }
                else ans+='p';
            }
            StringBuffer sb = new StringBuffer(ans);
            System.out.println("#"+tc+" "+sb.reverse().toString());
        }
    }
}
