import java.util.*;

public class PGMS_Table_Hash_Function {
    public static void main(String[] args) {

    }
    public int solution(int[][] data, int col, int row_begin, int row_end){
        int ans = 0;
        Arrays.sort(data, (o1, o2)-> {return (o1[col-1]==o2[col-1] ? o2[0] - o1[0] : o1[col-1] - o2[col-1]);});
        for(int i = row_begin-1 ; i<row_end; i++){
            int sum = 0;
            for(int column : data[i]) sum += (column % (i+1));
            ans ^= sum;
        }
        return ans;
    }
}
