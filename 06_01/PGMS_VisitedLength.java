public class PGMS_VisitedLength {
    public static void main(String[] args) {

    }
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    public int solution(String dirs){
        int ans = 0;
        int[][] map = new int[11][11];
        boolean visited[][][] = new boolean[11][11][4];
        int r = 5, c = 5;
        for(int i=0 ;i<dirs.length(); i++){
            char cc = dirs.charAt(i);
            int d = 0;
            if(cc=='U') d = 0;
            if(cc=='L') d = 1;
            if(cc=='D') d = 2;
            if(cc=='R') d = 3;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr<0 || nc<0 || nr>=11 || nc>=11)
                continue;
            if(!visited[nr][nc][d]){
                visited[nr][nc][d] = true;
                d = (d%2 == 0)? 2-d: 4-d;
                visited[r][c][d] = true;
                ans++;
            }
            r = nr;
            c = nc;
        }
        return ans;
    }
}
