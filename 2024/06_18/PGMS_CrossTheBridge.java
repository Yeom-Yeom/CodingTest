import java.util.*;
public class PGMS_CrossTheBridge {
    public static void main(String[] args) {

    }
    public int solution(int bridge_length, int weight, int[] truck_weights){
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;

        for(int t : truck_weights){
            while(true) {
                if (q.isEmpty()) {
                    q.offer(t);
                    sum += t;
                    ans++;
                    break;
                } else if (q.size() == bridge_length) {
                    sum -= q.poll();
                } else {
                    if (sum + t > weight) {
                        q.offer(0);
                        ans++;
                    } else {
                        q.offer(t);
                        sum += t;
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans+bridge_length;
    }
}
