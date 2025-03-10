import java.util.*;
class Solution{
    public static int solution(int n, int [][]q, int []ans){
        List<int[]> possibleCodes = new ArrayList<>();
        generateCombinations(possibleCodes, n, new int[5], 1, 0);

        int validCodeCount = 0;
        for(int[] code : possibleCodes){
            boolean isValid = true;
            for(int i=0; i<q.length; i++){
                int count = countMatching(code, q[i]);
                if(count!=ans[i]){
                    isValid = false;
                    break;
                }
            }
            if (isValid){
                validCodeCount++;
            }
        }
        return validCodeCount;
    }

    public static void generateCombinations(List<int[]> possibleCodes, int n, int[] combination, int start, int depth){
        if(depth == 5){
            possibleCodes.add(combination.clone());
            return;
        }
        for(int i=start; i<=n; i++){
            combination[depth] = i;
            generateCombinations(possibleCodes, n, combination, i+1, depth+1);
        }
    }

    public static int countMatching(int[] code, int[] guess){
        int count = 0;
        for(int num : guess){
            for(int c : code){
                if(num==c){
                    count++;
                }
            }
        }
        return count;
    }
}


// 다른 사람의 풀이
// import java.util.*;
// class Solution{
//     public static int[] visited;
//     public static int answer=0;
//     public static int [][] questions;
//     public static int[] answers;

//     public int solution(int n, int[][] q, int[] ans){
//         visited = new int[n+1];
//         questions = q;
//         answers = ans;

//         dfs(n,0,0);
//         return answer;
//     }

//     public void dfs(int n, int d, int b){
//         if(d==5){
//             calc();
//         }
//         for(int i=b+1; i<=n; i++){
//             if(visited[i]==0){
//                 visited[i] = 1;
//                 dfs(n, d+1, i);
//                 visited[i] = 0;
//             }
//         }
//     }

//     public void calc(){
//         int totalcount = 0;
//         for(int i=0; i<questions.length; i++){
//             int count = 0;
//             for(int j=0;j<5; j++){
//                 if(visited[questions[i][j]]==1){
//                     count++;
//                 }
//             }
//             if(count!=answers[i]){
//                 return;
//             }
//         }
//         answer++;
//     }
// }