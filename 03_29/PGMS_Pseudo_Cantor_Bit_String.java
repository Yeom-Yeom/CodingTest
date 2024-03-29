public class PGMS_Pseudo_Cantor_Bit_String {
    public static void main(String[] args) {

    }
    public int solution(int n, long l, long r){
        return countOne(n,l,r,1);
    }

    public int countOne(int n, long s, long e, long idx){
        if(n==0){
            return 1;
        }
        int num = 0;
        long part = (long)Math.pow(5,n-1);
        for(int i=0; i<5; i++){
            if(i==2 || e<(idx+part*i) || (idx+part*(i+1)-1)<s) continue;
            num += countOne(n-1,s,e,idx+part*i);
        }
        return num;
    }
}

/**
 * another solution
 * public int solution(int n, long l, long r){
 *     int ans = 0;
 *
 *     for(long val = l; val<=r; val++){
 *         ans+=query(n,val-1);
 *     }
 *     return ans;
 * }
 *
 * int query(int n, long l){
 *     if(n==0 || l==0){
 *         return 1;
 *     }
*      if(l%5==2){
 *          return 0;
 *      }
 *      return query(n-1,l/5);
 * }
 */