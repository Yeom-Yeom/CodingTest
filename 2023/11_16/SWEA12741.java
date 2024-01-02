import java.util.Scanner;

public class SWEA12741 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int ans = 0;
            if(a<c){
                if(b<c){
                    ans = 0;
                }else if(b<d){
                    ans = b-c;
                }else{
                    ans = d-c;
                }
            }else{
                if(d<a){
                    ans = 0;
                }else if(d<b){
                    ans = d-a;
                }else{
                    ans = b-a;
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
