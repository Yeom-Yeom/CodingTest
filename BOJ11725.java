import java.util.*;
public class BOJ11725 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i=0; i<n; i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++){
            int n1 = sc.nextInt() -1;
            int n2 = sc.nextInt() -1;
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int v = q.poll();
            for(int node : tree.get(v)){
                if(!visited[node]){
                    visited[node] = true;
                    q.offer(node);
                    parent[node] = v;
                }
            }
        }
        for(int i=1; i<n; i++){
            System.out.println(parent[i]+1);
        }
    }

}
