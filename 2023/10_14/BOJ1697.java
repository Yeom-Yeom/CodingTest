import java.util.*;
import java.io.*;
public class BOJ1697 {
    static int n,k;
    static int[] visited = new int[100001];
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int res = bfs(n);
        System.out.println(res);
    }
    public static int bfs(int node){
        q.add(node);
        int index = node;
        int n = 0;
        visited[index] = 1;
        while(!q.isEmpty()){
            n = q.remove();
            if(n==k){
                return visited[n]-1;
            }
            if(n-1>=0 && visited[n-1]==0){
                visited[n-1] = visited[n]+1;
                q.add(n-1);
            }
            if(n+1 <= 100000 && visited[n+1] == 0){
                visited[n+1] = visited[n]+1;
                q.add(n+1);
            }
            if(2*n <= 100000 && visited[2*n] == 0){
                visited[2*n] = visited[n]+1;
                q.add(2*n);
            }
        }
        return -1;
    }
}
