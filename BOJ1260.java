import java.io.*;
import java.util.*;

public class BOJ1260 {
    static int n,m,v;
    static int [][] tree;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        tree = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a][b] = 1;
            tree[b][a] = 1;
        }

        visited = new boolean[n+1];
        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v);
        System.out.println();
    }
    static void dfs(int v){
        visited[v] = true;
        System.out.print(v+" ");
        if(v == tree.length) return;
        for(int j=1; j<tree.length; j++){
            if(tree[v][j] == 1 && visited[j] == false){
                dfs(j);
            }
        }
    }

    static void bfs(int v){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);
        visited[v] = true;
        System.out.print(v+" ");
        while(!queue.isEmpty()){
            int n = queue.poll();
            for(int i=1; i<tree.length; i++){
                if(tree[n][i] == 1 && visited[i] == false){
                    visited[i] = true;
                    System.out.print(i+" ");
                    queue.offer(i);
                }
            }
        }
    }
}
