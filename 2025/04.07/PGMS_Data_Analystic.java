import java.util.*;
class Solution {
    public ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int []> answer = new ArrayList<>();
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("code",0);
        hashmap.put("date",1);
        hashmap.put("maximum",2);
        hashmap.put("remain",3);
        int n = hashmap.get(ext);
        int sortedIdx = hashmap.get(sort_by);

        for(int i=0; i<data.length; i++){
            if(data[i][n]<val_ext){
                answer.add(data[i]);
            }
        }

        answer.sort(Comparator.comparingInt(a->a[sortedIdx]));
        return answer;
    }
}

/**
 * 시간 복잡도를 줄인 gpt 코드
import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 문자열 키를 숫자 인덱스로 매핑
        int extIndex = getIndex(ext);
        int sortIndex = getIndex(sort_by);

        // 초기 용량 최적화
        List<int[]> filtered = new ArrayList<>(data.length);

        // 필터링
        for (int[] d : data) {
            if (d[extIndex] < val_ext) {
                filtered.add(d);
            }
        }

        // 정렬
        filtered.sort((a, b) -> Integer.compare(a[sortIndex], b[sortIndex]));

        return filtered;
    }

    private int getIndex(String key) {
        switch (key) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: throw new IllegalArgumentException("Invalid key: " + key);
        }
    }
}
**/
