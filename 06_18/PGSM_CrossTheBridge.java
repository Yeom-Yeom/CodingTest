import java.util.*;
public class PGSM_CrossTheBridge {
    public static void main(String[] args) {

    }
    public int solution(int bridge_length, int weight, int[] truck_weights){
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            q.offer(0);
        }
        if(bridge_length == 1) return truck_weights.length+1;
        if(truck_weights.length == 1) return bridge_length+1;

        int idx = 0;
        int curWeight = 0;
        while(idx < truck_weights.length){
            curWeight -= q.poll();
            ans++;

            if(curWeight + truck_weights[idx] <= weight){
                q.offer(truck_weights[idx]);
                curWeight += truck_weights[idx];
            }
            else q.offer(0);
        }
        return ans+bridge_length;
    }
}
