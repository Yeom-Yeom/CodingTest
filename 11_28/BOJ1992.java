import java.util.*;
import java.io.*;
public class BOJ1992 {
    public static int[][] img;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        img = new int[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                img[i][j] = str.charAt(j)-'0';
            }
        }

        QuadTree(0,0,n);
        System.out.println(sb);
    }
    public static void QuadTree(int x, int y, int size){
        if(isPossible(x,y,size)){
            sb.append(img[x][y]);
            return;
        }
        int newSize = size/2;
        sb.append('(');

        QuadTree(x,y,newSize);
        QuadTree(x,y+newSize, newSize);
        QuadTree(x+newSize, y, newSize);
        QuadTree(x+newSize, y+newSize, newSize);
        sb.append(')');
    }
    public static boolean isPossible(int x, int y, int size){
        int value = img[x][y];
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(value!=img[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
