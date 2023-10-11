import java.util.Scanner;

public class BOJ14888 {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] operator = new int[4];
    static int[] number;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        number = new int[n];
        for(int i=0; i<n; i++){
            number[i] = sc.nextInt();
        }

        for(int i=0; i<4; i++){
            operator[i] = sc.nextInt();
        }

        dfs(number[0],1);
        System.out.println(MAX);
        System.out.println(MIN);
    }
    public static void dfs(int num, int idx){
        if(idx == n){
            MAX = Math.max(MAX,num);
            MIN = Math.min(MIN,num);
            return;
        }
        for(int i=0; i<4; i++){
            if(operator[i] > 0){
                operator[i]--;
                switch (i){
                    case 0 : dfs(num+number[idx], idx+1); break;
                    case 1 : dfs(num-number[idx], idx+1); break;
                    case 2 : dfs(num*number[idx], idx+1); break;
                    case 3 : dfs(num/number[idx], idx+1); break;
                }
                operator[i]++;
            }
        }
    }
}
