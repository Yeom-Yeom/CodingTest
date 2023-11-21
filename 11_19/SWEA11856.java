import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SWEA11856 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++){
            String s = sc.next();
            String tmp = Arrays.asList(s.split("")).stream()
                    .distinct()
                    .collect(Collectors.joining());
            if(s.length()/2 == tmp.length()){
                System.out.println("#"+tc+" Yes");
            }
            else System.out.println("#"+tc+" No");
        }
    }
}
