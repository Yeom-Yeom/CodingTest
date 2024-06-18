import java.util.*;
public class PGMS_StockPrice {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,2,3}));
    }
    public static int[] solution(int[] prices){
        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<prices.length; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                ans[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            ans[stack.peek()] = prices.length - stack.peek()-1;
            stack.pop();
        }
        return ans;
    }
}
