import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        HashMap<String, Integer> dic = new HashMap<>();
        int[] giftDegree = new int[n];
        int[][] giftGraph = new int[n][n];

        for(int i=0; i<n; i++){
            dic.put(friends[i], i);
        }
        for(String gift: gifts){
            String[] tmp = gift.split(" ");
            giftDegree[dic.get(tmp[0])]++;
            giftDegree[dic.get(tmp[1])]--;
            giftGraph[dic.get(tmp[0])][dic.get(tmp[1])]++;
        }

        for(int i=0; i<n; i++){
            int num = 0;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(giftGraph[i][j] > giftGraph[j][i] || (giftGraph[i][j]==giftGraph[j][i] && giftDegree[i] > giftDegree[j])){
                    num++;
                }
            }
            if(answer<num) answer = num;
        }
        return answer;
    }
}