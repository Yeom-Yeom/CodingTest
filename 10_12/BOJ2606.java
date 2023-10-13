import java.util.*;
public class BOJ2606 {
    static int n;
    static int k;
    static boolean[] visited;
    static int[][] arr;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<k; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }
        System.out.println(dfs(1));
    }

    static int dfs(int v){
        visited[v] = true;
        for(int i=1; i<=n ;i++){
            if(arr[v][i] == 1 && visited[i] == false) {
                cnt++;
                dfs(i);
            }
        }
        return cnt;
    }
}
