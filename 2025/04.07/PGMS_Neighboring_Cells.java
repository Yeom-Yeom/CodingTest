class Solution {
    public int solution(String[][] board, int h, int w) {
        int ans = 0;
        int n = board.length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i=0;i<4; i++){
            int nx = w+dx[i];
            int ny = h+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(board[h][w].equals(board[ny][nx])) ans++;
            }

        }
        return ans;
    }
}