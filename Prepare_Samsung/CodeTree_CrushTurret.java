package Prepare_Samsung;

import java.util.*;
import java.io.*;
public class CodeTree_CrushTurret {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Turret implements Comparable<Turret>{
        int x;
        int y;
        int power;
        int attack;

        public Turret(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Turret(int x, int y, int power, int attack){
            this.x = x;
            this.y = y;
            this.power = power;
            this.attack = attack;
        }

        @Override
        public int compareTo(Turret t){
            if(this.power != t.power) return this.power-t.power;
            if(this.attack != t.attack) return t.attack - this.attack;
            if((this.x+this.y) != (t.x+t.y)) return (t.x+t.y) - (this.x+this.y);
            return t.y-this.y;
        }
    }

    // 우하좌상 -> 방향 우선순위
    static int[] dx = {0,1,0,-1,-1,-1,1,1};
    static int[] dy = {1,0,-1,0,-1,1,-1,1};

    static int n,m;
    static int[][] map;
    static int[][] attack; // 공격시점 저장
    static boolean[][] effect; // 영향 받았는지 확인 -> 공격 받았거나 공격자이거나 그 주변에 공격 받은 포탑인지 확인

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        attack = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // k번의 턴이 종료된 수 남아있는 포탑 중 가장 강한 포탑의 공격력 출력
        for(int time = 1; time<=k; time++){
            // 포탑이 하나만 있을 경우 종료
            if(isFinish()) break;

            effect = new boolean[n][m];

            // 1. 공격력이 가장 낮고 높은 포탑 찾기
            ArrayList<Turret> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] >0){
                        list.add(new Turret(i,j,map[i][j], attack[i][j]));
                    }
                }
            }

            Collections.sort(list);

            Turret start = list.get(0); // 공격자 (가장 약한 포탑)
            Turret end = list.get(list.size()-1); // 공격 대상 (가장 강한 포탑)

            // 공격력 증가
            map[start.x][start.y] += n+m;
            start.power = map[start.x][start.y];

            // 공격 시점 저장
            attack[start.x][start.y] = time;
            start.attack = time;

            effect[start.x][start.y] = true;

            // 2. 포탑 공격(레이저 공격 또는 포탄 공격) -> 레이저 공격을 하지 못하는 경우 포탄 공격
            if(!laser(start, end))
                bomb(start, end);

            // 3. 부서진 포탑(공격 받아서 공격력이 0이하인 포탑)은 신경 쓰지 않아도 됨

            // 4. 포탑정비 -> 공격자가 아님, 공격에 피해입은 포탑 아님, 부서지지 않은 포탑이라면 공격력 1 증가
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] > 0 && !effect[i][j]){
                        map[i][j]++;
                    }
                }
            }
        }

        // 남아있는 포탑 중 가장 강한 포탑의 공격력 출력
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                max = Math.max(max,map[i][j]);
            }
        }

        System.out.println(max);
    }

    // 레이저 공격 : bfs 사용 -> 공격자의 위치부터 시작 -> 공격 대상 위치까지 탐색 -> 만약 가는 길이 없다면 false 반환
    private static boolean laser(Turret start, Turret end){
        Turret[][] route = new Turret[n][m];

        Queue<Turret> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.add(new Turret(start.x, start.y));
        visited[start.x][start.y] = true;

        boolean isAttack = false;

        while(!q.isEmpty()){
            Turret cur = q.poll();

            // 공격 위치에 도달한 경우 종료
            if(cur.x == end.x && cur.y == end.y){
                isAttack = true;
                break;
            }

            for(int i=0; i<4; i++){
                int nx = (n+cur.x+dx[i])%n;
                int ny = (m+cur.y+dy[i])%m;

                // 방문하지 않았고 부서지지 않은 포탑인 경우
                if(!visited[nx][ny] && map[nx][ny] > 0){
                    q.add(new Turret(nx, ny));
                    visited[nx][ny] = true;
                    route[nx][ny] = new Turret(cur.x, cur.y);
                }
            }
        }
        if(isAttack){
            map[end.x][end.y] -= start.power;
            effect[end.x][end.y] = true;

            Turret turret = route[end.x][end.y];
            int x = turret.x;
            int y = turret.y;

            while(!(x==start.x && y==start.y)){
                map[x][y] -= start.power/2;
                effect[x][y] = true;

                turret = route[x][y];
                x = turret.x;
                y = turret.y;
            }
        }
        return isAttack;
    }

    // 포탄 공격 -> 매겨변수 : 공격자, 공격 대상
    private static void bomb(Turret start, Turret end){
        int power = start.power;

        map[end.x][end.y] -= power;
        effect[end.x][end.y] = true;

        power /= 2;

        // 공격 대상의 상하좌우, 대각선 위치의 포탄 공격력 감소
        for(int i=0; i<8; i++){
            int nx = (n+end.x+dx[i])%n;
            int ny = (m+end.y+dy[i])%m;

            // 공격자의 위치가 아닌 경우 (공격자는 포탄 공격에 영향 받지 않음)
            if(!(nx == start.x && ny == start.y)){
                map[nx][ny] -= power;
                effect[nx][ny] = true;
            }
        }
    }

    // 남아있는 포탑 개수 세기
    private static boolean isFinish(){
        int cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0;j<m; j++){
                if(map[i][j] > 0){
                    cnt++;
                }
            }
        }
        return cnt == 1;
    }
}