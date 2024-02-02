import java.util.*;
public class Virus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long K = sc.nextLong();
        long P = sc.nextLong();
        long N = sc.nextLong();

        long division = 1000000007;
        for(int i=0; i<N; i++){
            K*=P;
            K%=division;
        }

        System.out.println(K);
    }
}

/**
 * 문제 해석
 * N초 만큼 K인 바이러스가 P배 증가한다.
 * 0~(N-1) 반복문
 * K = K*P
 **/
