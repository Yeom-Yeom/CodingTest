import java.util.*;
public class BOJ11724 {
    static int n,m;
    static boolean[] visited;
    static int[][] arr;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }
        cnt = 0;
        for(int i=1;i<=n ;i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int v){
        visited[v] = true;
        for(int i=1 ;i<=n ;i++){
            if(arr[v][i] == 1 && !visited[i]){
               dfs(i);
            }
        }
    }
}
