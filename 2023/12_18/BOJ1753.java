import java.util.*;
import java.io.*;
public class BOJ1753 {
    static int INF = Integer.MAX_VALUE;
    static int V,E,K;
    static int[] dis;
    static List<Edge>[] edges;
    static PriorityQueue<Edge> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        q = new PriorityQueue<>(Comparator.comparing(Edge::getDistance));
        dis = new int[V+1];
        edges = new ArrayList[V+1];

        for(int i=0; i<=V; i++){
            dis[i] = INF;
            edges[i] = (new ArrayList<Edge>());
        }
        dis[K] = 0;
        q.add(new Edge(K,0));
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[u].add(new Edge(v,w));
        }
        while(!q.isEmpty()){
            Edge curEdge = q.poll();
            for(int i=0; i<edges[curEdge.node].size(); i++){
                Edge nextEdge = edges[curEdge.node].get(i);
                if(dis[nextEdge.node] <= dis[curEdge.node]+nextEdge.distance) continue;
                else{
                    dis[nextEdge.node] = dis[curEdge.node]+nextEdge.distance;
                    q.add(new Edge(nextEdge.node,dis[nextEdge.node]));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(dis[i]==INF) System.out.println("INF");
            else System.out.println(dis[i]+"");
        }
    }
    static class Edge{
        int node;
        int distance;
        public Edge(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
        public int getNode(){
            return node;
        }
        public int getDistance(){
            return distance;
        }
    }
}
