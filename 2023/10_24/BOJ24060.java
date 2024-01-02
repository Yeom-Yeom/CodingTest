import java.util.Scanner;

public class BOJ24060 {
    static int[] temp;
    static int count = 0;
    static int k;
    static int result = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        k = sc.nextInt();
        temp = new int[n];

        for(int i=0 ;i<n; i++){
            arr[i] = sc.nextInt();
        }
        merge_sort(arr,0,arr.length-1);
        System.out.println(result);
    }
    static void merge_sort(int a[], int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            merge_sort(a,low,mid);
            merge_sort(a,mid+1, high);
            merge(a,low,mid,high);
        }
    }
    static void merge(int a[], int low, int mid, int high){
        int i = low;
        int j = mid+1;
        int t = 0;
        while(i<=mid && j<=high){
            if(a[i]<=a[j])
                temp[t++] = a[i++];
            else temp[t++] = a[j++];
        }
        while(i<=mid){
            temp[t++] = a[i++];
        }
        while(j<=high){
            temp[t++] = a[j++];
        }
        t = 0;
        i = low;
        while(i<=high){
            count++;
            if(count==k){
                result = temp[t];
                break;
            }
            a[i++] = temp[t++];
        }
    }
}
