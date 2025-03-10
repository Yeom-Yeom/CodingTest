public class PSGM_TwoUnderBit {
    public static void main(String[] args) {

    }
    public long[] solution(long[] numbers){
        long[] ans = numbers.clone();
        for(int i=0 ;i<numbers.length; i++){
            ans[i]++;
            ans[i] += (ans[i]^numbers[i])>>2;
        }
        return ans;
    }
}
