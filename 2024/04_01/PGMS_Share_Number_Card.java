public class PGMS_Share_Number_Card {
    public static void main(String[] args) {

    }

    public static int solution(int[] arrayA, int[] arrayB){
        int ans = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for(int i=1; i<arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        if(unDivisible(arrayB, gcdA)){
            if(ans < gcdA)
                ans = gcdA;
        }
        if (unDivisible(arrayA, gcdB)) {
            if(ans < gcdB)
                ans = gcdB;
        }
        return ans;
    }
    public static int gcd(int a, int b){
        if(a%b==0) return b;
        return gcd(b,a%b);
    }

    public static boolean unDivisible(int[] arr, int num){
        for(int n : arr){
            if(n%num==0)
                return false;
        }
        return true;
    }
}
