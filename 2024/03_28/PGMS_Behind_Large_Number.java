import java.util.*;
public class PGMS_Behind_Large_Number {
    public static void main(String[] args) {

    }
    public int[] solution(int[] numbers){
        int[] ans = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for(int i=1; i<numbers.length; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                ans[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }
        return ans;
    }
}
