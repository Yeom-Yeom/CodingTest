import java.util.*;
public class PGMS_Cut_Array_Square_N {
    public static void main(String[] args) {

    }
    public List<Long> solution(int n, long left, long right){
        List<Long> list = new ArrayList<>();
        for(long i=left; i<right+1; i++){
            list.add(Math.max(i/n, i%n)+1);
        }
        return list;
    }
}
