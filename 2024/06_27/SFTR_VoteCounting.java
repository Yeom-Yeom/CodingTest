import java.util.*;

public class SFTR_VoteCounting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();
            if(n/5!=0){
                for(int j=0; j<n/5; j++){
                    sb.append("++++ ");
                }
            }
            n%=5;
            if(n!=0){
                for(int j=0; j<n; j++){
                    sb.append("|");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
