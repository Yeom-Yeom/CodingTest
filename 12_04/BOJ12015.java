import java.util.*;
public class BOJ12015 {
    public static List<Integer> lis = new ArrayList<>();
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        lis.add(0);
        for(int i=0; i<n; i++){
            if(arr[i] > lis.get(lis.size()-1))
                lis.add(arr[i]);
            else{
                int idx = binarySearch(0,lis.size()-1, arr[i]);
                lis.set(idx,arr[i]);
            }
        }
        System.out.println(lis.size()-1);
    }
    public static int binarySearch(int start, int end, int value){
        if(start == end) return end;
        int mid = (start+end)/2;
        if(lis.get(mid)>=value) return binarySearch(start,mid,value);
        else return binarySearch(mid+1, end, value);
    }
}
