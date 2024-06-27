import java.util.*;
public class PGMS_Clothes {
    public static void main(String[] args) {

    }
    public int solution(String[][] clothes){
        int ans = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0 ;i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }
        for(String key : map.keySet()){
            ans *= (map.get(key)+1);
        }
        ans-=1;
        return ans;
    }
}
