import java.util.*;
public class BriquetSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        for(int i=2; i<=100; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(arr[j]%i==0){
                    cnt++;
                }
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }

}

/**
 * 문제 해석
 * 반지름의 길이의 조건이 2~100이 될 수 있으므로 2부터 100까지 반복문
 * 주어진 집에 놓여있는 반지름의 길이를 2부터 시작하는 변수 i로 나누었을 때 나머지가 0인 것이
 * 난로의 길이가 연탄의 길이의 배수가 된다.
 * 구한 값을 저장해놓고, 이후에 구한 값들과 비교하여 더 큰 값이 나오면 대체
 * 그래야지만 최대한 많은 집에 연탄을 사용할 수 있도록 한다.
 **/