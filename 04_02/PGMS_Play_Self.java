import java.util.*;
public class PGMS_Play_Self {
    public static void main(String[] args) {

    }
    static boolean[] visit;
    static int depth;

    public int solution(int[] cards){
        int ans = 0;
        int len = cards.length;
        visit = new boolean[len+1];
        List<Integer> list = new ArrayList<>();
        for(int i=0 ;i<len; i++){
            if(!visit[i+1]){
                depth = 1;
                visit[i+1] = true;
                open(cards[i], cards);
                list.add(depth);
            }
        }
        if(list.size() < 2) return 0;
        Collections.sort(list, Collections.reverseOrder());
        ans = list.get(0)*list.get(1);
        return ans;
    }

    public static void open(int x, int[] cards){
        if(!visit[x]){
            visit[x] = true;
            depth+=1;
            open(cards[x-1], cards);
        }
    }
}
