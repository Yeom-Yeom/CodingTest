import java.util.*;
public class SecretMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        String secret = "";
        String input = "";
        for(int i=0; i<m; i++){
            secret += sc.nextInt();
        }
        for(int i=0; i<n; i++){
            input += sc.nextInt();
        }
        if(input.contains(secret)){
            System.out.println("secret");
        }else System.out.println("normal");
    }
}

/**
 * 문제 해석
 * 입력받은 secret이 input안에 존재하면 secret을 출력
 * 아니면 normal을 출력
 **/

/**
 * 놓친 부분
 * String 에 += 을 사용하여 sc.nextInt()를 입력할 수 있는 줄 몰랐다.
 * String의 contains를 사용하면 매우 간단한 문제지만, 이를 몰라 array에 입력을 받고
 * 원소별로 비교하여 같으면 반환을 하려고 했으나 반복문이 여러번 나와 시간 복잡도가 길어진다.
 **/