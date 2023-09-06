import java.util.*;
import java.io.*;
public class BOJ2485 {
    static int[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new int[n];
        for(int i=0; i<n; i++){
            tree[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tree);
        int gcd = 0;
        for(int i=0; i<n-1; i++){
            int distance = tree[i+1]-tree[i];
            gcd = GCD(distance, gcd);
        }
        System.out.println((tree[n-1]-tree[0])/gcd+1-(tree.length));
    }
    static public int GCD(int a, int b){
        if (b==0) return a;
        else return GCD(b,a%b);
    }
}
