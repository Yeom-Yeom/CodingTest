import java.util.*;
import java.io.*;
public class BOJ24479 {
    static int[] ans;
    static ArrayList<Integer>[] edges;
    static int idx=0;
    static boolean[] vertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            edges[i] = new ArrayList<>();
        }
        ans = new int[n+1];
        vertex = new boolean[n+1];
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }
        for(int i=1; i<=n; i++){
            Collections.sort(edges[i]);
        }
        vertex[r] = true;
        dfs(r);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(ans[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int cur){
        ans[cur] = ++idx;
        for(int next : edges[cur]){
            if(vertex[next]) continue;
            vertex[next] = true;
            dfs(next);
        }
    }
}
