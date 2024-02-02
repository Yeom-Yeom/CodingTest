import java.util.*;
public class MapAutoCreation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 2;
        for(int i=0; i<n; i++){
            ans = ans+(ans-1);
        }
        System.out.println(ans*ans);
    }
}

/**
 * 문제 해석
 * 처음 주어진 점 4개에서 단계가 추가될 때 마다
 * 이전 단계의 모서리 부분에서 점 사이에 점이 추가가 된다.
 * 즉, 2개의 점이 있다면 그 사이에 점이 하나 찍히는 것이므로 3개가 되고
 * 3개의 점이 있다면, 그 사이에 점이 2개 찍히는 것이므로 5개가 된다.
 * 규칙을 구하면 이 전에 있던 점의 갯수를 n이라고 하면, 이후에 모서리의 점 개수는 n+(n-1)이 된다.
 * 결국 모든 점들의 개수는 구한 모서리의 점 개수의 제곱이다.
 **/