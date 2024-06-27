import java.util.*;
public class PGMS_Process {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
    }
    public static int solution(int[] priorities, int location){
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : priorities){
            queue.offer(p);
        }
        while(!queue.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(queue.peek() == priorities[i]){
                    queue.poll();
                    ans++;
                    if(location == i)
                        return ans;
                }
            }
        }
        return ans;
    }
}
