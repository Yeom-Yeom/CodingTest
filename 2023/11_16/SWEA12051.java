import java.util.Scanner;

public class SWEA12051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            long N = sc.nextLong();
            int Pd = sc.nextInt();
            int Pg = sc.nextInt();
            String ans = " Broken";
            if(!(Pg==100 && Pd !=100 || Pg==0 && Pd>0)){
                while(N>0){
                    if((N-- * Pd) %100 ==0){
                        ans = " Possible";
                        break;
                    }
                }
            }
            System.out.println("#"+test_case+ans);
        }
    }
}
