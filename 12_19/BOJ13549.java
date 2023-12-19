import java.util.*;
import java.io.*;
public class BOJ13549 {
    static class Loc{
        int idx;
        int time;
        public Loc(int idx, int time){
            this.idx = idx;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001];

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(n,1));
        visited[n] = 1;

        while(!q.isEmpty()){
            Loc now = q.poll();
            if(now.idx+1>=0 && now.idx+1<=100000){
                if(visited[now.idx+1] == 0 || visited[now.idx+1] > now.time+1){
                    visited[now.idx+1] = now.time+1;
                    q.add(new Loc(now.idx+1, now.time+1));
                }
            }

            if(now.idx-1>=0 && now.idx-1 <= 100000){
                if(visited[now.idx-1] == 0 || visited[now.idx-1] > now.time+1){
                    visited[now.idx-1] = now.time+1;
                    q.add(new Loc(now.idx-1, now.time+1));
                }
            }
            if(now.idx*2>=0 && now.idx*2<=100000){
                if(visited[now.idx*2] ==0 || visited[now.idx*2] > now.time){
                    visited[now.idx*2] = now.time;
                    q.add(new Loc(now.idx*2, now.time));
                }
            }
        }
        System.out.println(visited[m]-1);
    }
}
