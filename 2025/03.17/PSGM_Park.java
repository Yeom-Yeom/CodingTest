import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        List<Integer> matList = new ArrayList<>();
        Arrays.stream(mats).forEach(matList::add);
        Collections.sort(matList);

        for(int i=0; i<park.length; i++){
            if(matList.isEmpty()) break;

            for(int j=0; j<park[i].length; j++){
                if(matList.isEmpty()) break;
                if(park[i][j].equals("-1")){
                    while(!matList.isEmpty()){
                        Integer mat = matList.get(0);
                        boolean flag = true;
                        for(int y= i; y<Math.min(i+mat, park.length); y++){
                            for(int x=j; x<Math.min(j+mat, park[y].length); x++){
                                if(park.length-i<mat || park[i].length-j< mat || !park[y][x].equals("-1")){
                                    flag = false;
                                    break;
                                }
                            }
                            if(!flag) break;
                        }
                        if(!flag){
                            break;
                        }else{
                            answer = matList.get(0);
                            matList.remove(0);
                        }
                    }
                }
            }
        }

        return answer;
    }
}